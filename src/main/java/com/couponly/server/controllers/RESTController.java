package com.couponly.server.controllers;

import com.couponly.server.model.Coordinates;
import com.couponly.server.model.DealWrapper;
import com.couponly.server.model.RawResponse;
import com.couponly.server.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private RequestService requestService;
    private Logger logger = LoggerFactory.getLogger(RESTController.class);

    @GetMapping(value = "/test", produces = "application/json")
    public RawResponse getRawResponse() {
        RawResponse response = requestService.requestRawResponse();
//        logger.info(String.valueOf(response));
        return response;
    }
    @GetMapping(value = "/get-all-deals", produces = "application/json")
    public List<DealWrapper> getAllDeals() {
        return requestService.requestAllDeals("");
    }
//    @GetMapping(value = "/deals-by-location", produces = "application/json")
//    public void getDealsByLocation(@RequestParam double latitude, @RequestParam double longtitude) {
//        Coordinates coor = new Coordinates(latitude, longtitude);
//        logger.info(Double.toString(coor.getLatitude()));
//    }
    @GetMapping(value = "/deals-by-location", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DealWrapper>> getDealsByLocation(@RequestParam String locationName) {
        List<DealWrapper> deals = requestService.requestDealsByLocation(locationName);
//        logger.info(Double.toString(coors.getLatitude()));
        return new ResponseEntity(deals,HttpStatus.OK);
    }
}
