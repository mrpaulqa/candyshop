package com.candyshop.invoice.entrypoint;


import com.candyshop.invoice.entity.Candy;
import com.candyshop.invoice.entity.CandyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CandyService {

    @Autowired
    private RestTemplate restTemplate;

    // Reach out Person CandyApplication
    private String baseUrl = "http://localhost:8080/";

    //Could have get mapping without any problems.
    public CandyResponse getAllCandies() {
        return callApi("/candy", CandyResponse.class);
    }

    public Candy getACandy(Integer id) {
        return callApi("/candy/" + id, Candy.class);
    }

    public Candy getCandyComposition(Integer id) {
        return callApi("/candy/" + id + "/composition", Candy.class);
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private <T> T callApi(String path, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(baseUrl + path, HttpMethod.GET, entity, responseType).getBody();
    }
}
