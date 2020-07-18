package com.couponly.server.repositories;

import com.couponly.server.model.responses.Merchant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
public class MerchantDAO {
    private final MerchantRepository repo;

    public MerchantDAO(MerchantRepository repo) {
        this.repo = repo;
    }
    //c
    public void addMerchant(Merchant merchant) {
        repo.save(merchant);
    }
    //r
    public Merchant fetchMerchant(Long id) throws EntityNotFoundException {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    //u
    //d
    public void deleteMerchant(Long id) {
        repo.findById(id);
    }
}
