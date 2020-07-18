package com.couponly.server.services;

import com.couponly.server.model.responses.Deal;
import com.couponly.server.model.responses.RawResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RequestService {
    private final OkHttpClient client;
    private final Gson gson = new Gson();

    @Value("${secret.key}")
    private String KEY;
    private final String BASE_URL = "api.discountapi.com";
    private final String PATH = "/v2/deals";
    private final List<NameValuePair> parameterGroup = new ArrayList<>();

    public RequestService(OkHttpClient client) {
        this.client = client;
        Map<String, String> responsePreferences = Map.of(
                "online", "false",
                "provider_slugs", "groupon",
                "radius", "40");
        mapToNameValuePair(responsePreferences);
    }


    public RawResponse requestDealsByParameters(Map<String, String> params) {
        return makeRequest(buildUri(params));
    }

    private URI buildUri(Map<String, String> params) {
        mapToNameValuePair(params);
        URI uri = null;
        try {
            uri =  new URIBuilder()
                    .setScheme("https")
                    .setHost(BASE_URL)
                    .setPath(PATH)
                    .setParameters(parameterGroup)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }
    private RawResponse makeRequest(URI uri) {
        Request request = new Request.Builder()
                .url(uri.toString())
                .addHeader("Authorization", "api_key " + KEY)
                .build();
        return getRawResponse(request);
    }

    public RawResponse basicRequest(String params) {
        Request request = new Request.Builder()
                .url("https://"+BASE_URL + PATH)
                .addHeader("Authorization", "api_key " + KEY)
                .build();
        return getRawResponse(request);
    }
    private RawResponse getRawResponse(Request request) {
        Response response = null;
        String json = "";
        try {
            response = client.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, RawResponse.class);
    }
    //Local response
    public List<Deal> mockResponse(){
        String userDirectory = System.getProperty("user.dir");
        StringBuilder sb =  new StringBuilder();
        File file = new File(userDirectory + "\\src\\main\\resources\\assets\\pizzas.json");

        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader,new TypeToken<List<Deal>>(){}.getType());
    }
    //Helper Methods
    private void mapToNameValuePair(Map<String, String> paramInput) {
        paramInput.forEach((key ,value) -> parameterGroup.add(new BasicNameValuePair(key, value)));
    }
}
