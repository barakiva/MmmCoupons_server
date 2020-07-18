package com.couponly.server.services;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
class RequestServiceTest {
    @MockBean private RequestService service;
    @MockBean private OkHttpClient client;


    @Test
    void basicRequest() throws IOException {
        service.basicRequest(anyString());
//        verify(service).basicRequest(anyString());
        Request request = mock(Request.class);
        when(client.newCall(request)).thenReturn(mock(Call.class));

    }
}
