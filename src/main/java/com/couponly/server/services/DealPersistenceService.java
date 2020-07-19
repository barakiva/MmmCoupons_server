package com.couponly.server.services;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.repositories.DealDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealPersistenceService {
    private final DealDAO dao;

    public DealPersistenceService(DealDAO dao) {
        this.dao = dao;
    }

    public void persistDeals(List<Deal> deals) {
        deals.forEach(dao::addDeal);
    }
}
