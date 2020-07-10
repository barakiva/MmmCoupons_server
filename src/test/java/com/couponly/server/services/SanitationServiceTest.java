package com.couponly.server.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SanitationServiceTest {
    @Autowired
    private SanitationService service;

    @Test
    void cleanUrls() {
        List<String> dirtyUrls = Arrays.asList("https://api.discountapi.com/v2/deals/1988753/click?api_key=secret",
                "https://api.discountapi.com/v2/deals/1988753/click?api_key=secret");
        assertTrue(service.cleanUrls(dirtyUrls).stream()
                    .noneMatch(url -> url.contains("api_key")));
    }
}
