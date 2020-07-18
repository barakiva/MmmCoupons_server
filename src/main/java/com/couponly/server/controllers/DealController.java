package com.couponly.server.controllers;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.model.responses.DealWrapper;
import com.couponly.server.model.responses.RawResponse;
import com.couponly.server.services.DealRequestService;
import com.couponly.server.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final DealRequestService dealRequestService;
    private final ServletContext servletContext;

    private final Logger logger = LoggerFactory.getLogger(DealController.class);

    public DealController(DealRequestService dealRequestService, ServletContext servletContext) {
        this.dealRequestService = dealRequestService;
        this.servletContext = servletContext;
    }

    @GetMapping(value = "/raw-response", produces = "application/json")
    public ResponseEntity<RawResponse> getRawResponse() {
        return new ResponseEntity<>(dealRequestService.fetchRawResponse(), HttpStatus.OK);
    }
    @GetMapping(value = "/get-all-deals", produces = "application/json")
    public ResponseEntity<List<Deal>> getAllDeals() {
        List<Deal> deals = dealRequestService.fetchAllDeals(Map.of(
                "a", "b",
                "c", "d"
        )).subList(0,8);
        return new ResponseEntity<>(deals, HttpStatus.OK);
    }

    @GetMapping(value = "/deals-by-location", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocation(@RequestParam String locationName) {
        List<Deal> deals = dealRequestService.fetchDealsByLocation(locationName);
        return new ResponseEntity<>(deals,HttpStatus.OK);
    }

    @GetMapping(value = "/location-and-query", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQuery(
            @RequestParam Map<String, String> params) {
        List<Deal> deals = dealRequestService.fetchDealsByLocationAndQuery(params);
        return new ResponseEntity<>(deals,HttpStatus.OK);
    }
    //Mock local response
    @GetMapping(value = "/location-and-query-local", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQueryLocal(
            @RequestParam Map<String, String> params) {
        List<Deal> list = dealRequestService.fetchLocalResponse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
