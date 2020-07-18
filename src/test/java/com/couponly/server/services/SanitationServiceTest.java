package com.couponly.server.services;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.model.responses.DealWrapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class SanitationServiceTest {
    @MockBean
    private SanitationService service;
    @Mock Deal deal;
    @Mock DealWrapper wrapper;

    List<Deal> dirtyDeals;
    List<String> dirtyUrls = Arrays.asList("https://api.discountapi.com/v2/deals/1988753/click?api_key=secret",
            "https://api.discountapi.com/v2/deals/1988753/click?api_key=secret");

    @BeforeAll
    public void setUp(){
        when(deal.getImageUrl()).thenReturn(dirtyUrls.get(0));
        when(deal.getUrl()).thenReturn(dirtyUrls.get(1));
        dirtyDeals = Arrays.asList(deal,deal,deal);

        when(wrapper.getDeal()).thenReturn(new Deal());
    }
    @Test
    public void isDealsSetUp(){
        assertTrue(dirtyDeals.stream()
                .anyMatch(deal -> deal.getImageUrl().contains("api_key")));
    }

    @Test
    void cleanUrls() {
        assertTrue(service.cleanUrls(dirtyUrls).stream()
                    .noneMatch(url -> url.contains("api_key")));
    }
    @Test
    void cleanApiKeys() {
        assertTrue(service.cleanApiKeys(dirtyDeals).stream()
                    .noneMatch(url -> url.getUrl().contains("api_key")));
        assertTrue(service.cleanApiKeys(dirtyDeals).stream()
                .noneMatch(url -> url.getImageUrl().contains("api_key")));
    }

    @Test
    void dealUnwrap(){
        List<DealWrapper> dealWrappers = new ArrayList<>();
        assertNotNull(service.dealUnwrap(dealWrappers));
    }
}
