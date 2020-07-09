package com.couponly.server.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SanitationServiceTest {
    private final SanitationService service;

    public SanitationServiceTest(SanitationService service) {
        this.service = service;
    }

    @Test
    void cleanApiKey() {
        String dirtyUrl = "https://api.discountapi.com/v2/deals/1988753/click?api_key=secret";
        String cleanUrl = "https://api.discountapi.com/v2/deals/1988753/click";
    }
    @Test
    void cleanUrls() {
        String[] dirtyUrls = {"https://api.discountapi.com/v2/deals/1988753/click?api_key=secret", "https://api.discountapi.com/v2/deals/1988753/click?api_key=secret"};
        String[] cleanUrls = service.cleanUrls(dirtyUrls);
        System.out.println(cleanUrls);
    }
}
