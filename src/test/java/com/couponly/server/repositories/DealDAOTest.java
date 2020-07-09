package com.couponly.server.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@SpringBootTest
class DealDAOTest {
    @Autowired private DealRepository repo;
    public DealDAOTest() {

    }
    @Test
    void dataSourceIsCorrect(){
        assertThat(repo).isNotNull();
    }
    @Test
    void addDeal() {
    }

    @Test
    void fetchDeal() {
    }

    @Test
    void deleteDeal() {
    }
}
