package com.couponly.server.services;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.model.responses.RawResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DealRequestService {
    private final RequestService requestService;
    private final SanitationService sanitationService;

    public DealRequestService(RequestService requestService, SanitationService sanitationService) {
        this.requestService = requestService;
        this.sanitationService = sanitationService;
    }

    public RawResponse fetchRawResponse() {
        return requestService.basicRequest("");
    }
    public List<Deal> fetchAllDeals(Map<String, String> params) {
        List<Deal> deals = sanitationService.dealUnwrap(
                requestService.makeComplexRequest(params).getDeals());
        return sanitationService.cleanApiKeys(deals);
    }
    public List<Deal> fetchDealsByLocation(String location) {
        List<Deal> deals = sanitationService.dealUnwrap(
                requestService.requestDealsByLocation("").getDeals());
        return sanitationService.cleanApiKeys(deals);
    }
    public List<Deal> fetchDealsByLocationAndQuery(Map<String, String> params) {
        List<Deal> deals = sanitationService.dealUnwrap(
                requestService.makeComplexRequest(params).getDeals());
        return sanitationService.cleanApiKeys(deals);
    }
    public List<Deal> fetchLocalResponse() {
        return requestService.mockResponse();
    }

}
