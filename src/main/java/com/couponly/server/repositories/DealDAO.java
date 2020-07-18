package com.couponly.server.repositories;

import com.couponly.server.model.responses.Deal;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityNotFoundException;

@Repository
public class DealDAO {
    private final DealRepository repo;
    public DealDAO(DealRepository repository) {
        this.repo = repository;
    }
    //Transactional  It is used to combine more than one writes on a database as a single atomic operation.
    //Create
    public void addDeal(Deal deal) {
        repo.save(deal);
    }
    //Read
    public Deal fetchDeal(Long id) throws EntityNotFoundException {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    //Update

    //Delete
    public void deleteDeal(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }
}
