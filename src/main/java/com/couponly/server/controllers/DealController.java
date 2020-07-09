package com.couponly.server.controllers;

import com.couponly.server.model.Deal;
import com.couponly.server.model.DealWrapper;
import com.couponly.server.model.RawResponse;
import com.couponly.server.services.RequestService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final RequestService requestService;
    private final ServletContext servletContext;

    private final Logger logger = LoggerFactory.getLogger(DealController.class);
    private final Gson gson = new Gson();

    public DealController(RequestService requestService, ServletContext servletContext) {
        this.requestService = requestService;
        this.servletContext = servletContext;
    }

    @GetMapping(value = "/raw-response", produces = "application/json")
    public ResponseEntity<RawResponse> getRawResponse() {
        return new ResponseEntity<>(requestService.requestRawResponse(), HttpStatus.OK);
    }
    @GetMapping(value = "/get-all-deals", produces = "application/json")
    public ResponseEntity<List<Deal>> getAllDeals() {
        List<DealWrapper> deals = requestService.requestAllDeals("").subList(0,8);
        return new ResponseEntity<>(dealUnwrap(deals), HttpStatus.OK);
    }

    @GetMapping(value = "/deals-by-location", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DealWrapper>> getDealsByLocation(@RequestParam String locationName) {
        List<DealWrapper> deals = requestService.requestDealsByLocation(locationName);
        return new ResponseEntity<>(deals,HttpStatus.OK);
    }

    @GetMapping(value = "/location-and-query", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQuery(
            @RequestParam Map<String, String> params) {

        List<DealWrapper> deals = requestService.makeComplexRequest(params);
        return new ResponseEntity<>(dealUnwrap(deals),HttpStatus.OK);
    }
    //Mock local response
    @GetMapping(value = "/location-and-query-local", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Deal>> getDealsByLocationAndQueryLocal(
            @RequestParam Map<String, String> params) {
        List<Deal> list = requestService.mockResponse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //Helper
    private List<Deal> dealUnwrap(List<DealWrapper> dealWrappers) {
        List<Deal> deals = new ArrayList<>();
        dealWrappers.forEach(dealWrapper -> {
            deals.add(dealWrapper.getDeal());
        });
        return deals;
    }
}
