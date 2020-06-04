package com.couponly.server.controllers;

import com.couponly.server.model.Deal;
import com.couponly.server.model.RawResponse;
import com.couponly.server.services.RequestService;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private RequestService requestService;
    private Logger logger = LoggerFactory.getLogger(RESTController.class);

    @GetMapping(value = "/test", produces = "application/json")
    public RawResponse getRawResponse() {
        return requestService.makeRequest("");
    }
    @GetMapping(value = "/get-all-deals", produces = "application/json")
    public List<Deal> getAllDeals() {
        RawResponse rawResponse = requestService.makeRequest("");
        List<Deal> dealList = rawResponse.getDeals();
        logger.info(rawResponse.getDeals().get(1).getCategoryName());
        return dealList;
    }

}
