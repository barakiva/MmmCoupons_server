package com.couponly.server.controllers;

import com.couponly.server.model.Deal;
import com.couponly.server.model.DealWrapper;
import com.couponly.server.model.RawResponse;
import com.couponly.server.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private RequestService requestService;
    private Logger logger = LoggerFactory.getLogger(RESTController.class);

    @GetMapping(value = "/test", produces = "application/json")
    public RawResponse getRawResponse() {
        RawResponse response = requestService.requestRawResponse();
        return response;
    }
    @GetMapping(value = "/get-all-deals", produces = "application/json")
    public List<Deal> getAllDeals() {
        List<DealWrapper> deals = requestService.requestAllDeals("").subList(0,8);
        return dealUnwrap(deals);
    }

    @GetMapping(value = "/deals-by-location", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DealWrapper>> getDealsByLocation(@RequestParam String locationName) {
        List<DealWrapper> deals = requestService.requestDealsByLocation(locationName);
        return new ResponseEntity(deals,HttpStatus.OK);
    }

    @GetMapping(value = "/location-and-query", produces = "application/json")
    @ResponseBody
    public List<Deal> getDealsByLocationAndQuery(
            @RequestParam Map<String, String> params) {
        List<DealWrapper> deals = requestService.makeComplexRequest(params);
        return dealUnwrap(deals);
    }

    private List<Deal> dealUnwrap(List<DealWrapper> dealWrappers) {
        List<Deal> deals = new ArrayList<>();
        dealWrappers.forEach(dealWrapper -> {
            deals.add(dealWrapper.getDeal());
        });
        return deals;
    }
}
