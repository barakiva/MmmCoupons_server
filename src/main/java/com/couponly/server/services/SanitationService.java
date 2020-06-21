package com.couponly.server.services;

import com.couponly.server.model.DealWrapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanitationService {
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(SanitationService.class);

    public List<DealWrapper> cleanApiKey(List<DealWrapper> dealWrappers) {
        List<DealWrapper> cleanList = new ArrayList<>();
        dealWrappers.forEach(item -> {
            cleanList.add(cleanWrapper(item));
        });
        return cleanList;
    }
    private DealWrapper cleanWrapper(DealWrapper wrapper) {
        String imgUrl = wrapper.getDeal().getImageUrl();
        String[] cleanUrl = imgUrl.split("\\?");
        wrapper.getDeal().setImageUrl(cleanUrl[0]);

        return wrapper;
    }
}
