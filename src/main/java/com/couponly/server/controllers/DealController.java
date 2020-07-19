package com.couponly.server.controllers;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.model.responses.RawResponse;
import com.couponly.server.services.DealFetchService;
import com.couponly.server.services.DealPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final DealFetchService dealFetchService;
    private final DealPersistenceService dealPersistenceService;

    private final Logger logger = LoggerFactory.getLogger(DealController.class);

    public DealController(DealFetchService dealFetchService, DealPersistenceService dealPersistenceService) {
        this.dealFetchService = dealFetchService;
        this.dealPersistenceService = dealPersistenceService;
    }

    @GetMapping(value = "/raw-response", produces = "application/json")
    public ResponseEntity<RawResponse> getRawResponse() {
        return new ResponseEntity<>(dealFetchService.fetchRawResponse(), HttpStatus.OK);
    }

    @GetMapping(value = "/location-and-query", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQuery(
            @RequestParam Map<String, String> params) {
        List<Deal> deals = dealFetchService.fetchDeals(params);
        dealPersistenceService.persistDeals(deals);
        return new ResponseEntity<>(deals,HttpStatus.OK);
    }
    //Mock local response
    @GetMapping(value = "/location-and-query-local", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQueryLocal(
            @RequestParam Map<String, String> params) {
        List<Deal> list = dealFetchService.fetchLocalResponse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
