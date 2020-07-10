package com.couponly.server.services;

import com.couponly.server.model.Deal;
import com.couponly.server.model.DealWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanitationService {

    public List<Deal> cleanApiKeys(List<Deal> deals) {
        List<Deal> cleanList = new ArrayList<>();
        deals.forEach(item -> {
            //Catching "dirty" URLs containing API keys
            List<String> dirtyUrls = Arrays.asList(item.getUrl(), item.getImageUrl()); //*ask maybe map?
            List<String> cleanUrls = cleanUrls(dirtyUrls);
            cleanList.add(cleanDeal(item ,cleanUrls));
        });
        return cleanList;
    }
    public Deal cleanDeal(Deal deal, List<String> cleanUrls) {
        deal.setUrl(cleanUrls.get(0));
        deal.setImageUrl(cleanUrls.get(1));
        return deal;
    }
    public List<String> cleanUrls(List<String> urls) {
        return urls.stream()
                .map(url -> url =  url.split("\\?")[0])
                .collect(Collectors.toList());
    }
    public List<Deal> dealUnwrap(List<DealWrapper> dealWrappers) {
        return dealWrappers.stream()
                .map(DealWrapper::getDeal)
                .collect(Collectors.toList());
    }
}
