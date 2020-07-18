package com.couponly.server.repositories;

import com.couponly.server.configuration.Config;
import com.couponly.server.model.responses.Deal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes= Config.class)
//@DataJpaTest

//@SpringBootTest
class DealDAOTest {
//    @Mock DealRepository repo;

    public DealDAOTest() {

    }
    @Test
    void dataSourceIsCorrect(){

    }
    @Test
    void addDeal() {
        DealDAO repo = mock(DealDAO.class);
        Deal deal = mock(Deal.class);
        verify(repo).addDeal(deal);
    }

    @Test
    void fetchDeal() {
    }

    @Test
    void deleteDeal() {
    }
}
