package com.couponly.server.services;

import com.couponly.server.model.Deal;
import com.couponly.server.model.DealWrapper;
import com.couponly.server.model.RawResponse;
import com.google.gson.Gson;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RequestService {
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    @Value("${secret.key}")
    private String KEY;
    private String BASE_URL = "https://api.discountapi.com/v2/deals";
    private String CONFIG = "&online=false";

    private Logger logger = LoggerFactory.getLogger(RequestService.class);
    public RawResponse requestRawResponse() {
        return makeRequest("");
    }
    public List<DealWrapper> requestAllDeals(String params) {
       return makeRequest(params).getDeals();
    }
    public List<DealWrapper> requestDealsByLocation(String locationName) {
        return makeRequest("location=" + locationName).getDeals();
    }
    private RawResponse makeRequest(String params) {
        String url = BASE_URL + "?" + params + CONFIG;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "api_key " + KEY)
                .build();
        Response response = null;
        String json = "";

        try {
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        logger.info(json);
        RawResponse rawResponse = gson.fromJson(json, RawResponse.class);
//        logger.warn(gson.toJson(rawResponse));
//        Deal deal = rawResponse.getDeals().get(0).getDeal();
//        logger.info(deal.getShortTitle());
        return rawResponse;
    }

}
