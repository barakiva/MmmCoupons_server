package com.couponly.server.services;

import com.couponly.server.model.Deal;
import com.couponly.server.model.DealWrapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SanitationService {
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(SanitationService.class);

    public List<Deal> cleanApiKeys(List<Deal> deals) {
        List<Deal> cleanList = new ArrayList<>();
        deals.forEach(item -> {
            String[] dirtyUrls = {item.getUrl(), item.getImageUrl()}; //*ask maybe map?
            String[] cleanUrls = cleanUrls(dirtyUrls);
            cleanList.add(cleanDeal(item));
        });
        return cleanList;
    }
    public Deal cleanDeal(Deal deal) {
        String imgUrl = deal.getImageUrl();
        String[] cleanUrl = imgUrl.split("\\?");
        deal.setImageUrl(cleanUrl[0]);
        return deal;
    }
    public String[] cleanUrls(String[] urls) {
        Arrays.stream(urls)
                .forEach(url -> url =  url.split("\\?")[0]);
        return urls;
    }
    public List<Deal> dealUnwrap(List<DealWrapper> dealWrappers) {
        List<Deal> deals = new ArrayList<>();
        dealWrappers.forEach(dealWrapper -> {
            deals.add(dealWrapper.getDeal());
        });
        return deals;
    }
}
