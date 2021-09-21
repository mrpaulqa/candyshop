package com.pavlo.candyshop.entrypoint;

import com.pavlo.candyshop.entity.CandiesResponse;
import com.pavlo.candyshop.entity.Candy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//Could be a Rest Controller without any problems.
@Controller
public class CandyConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // Reach out Person Application
    private String baseUrl = "http://localhost:8080/";

    //Could have get mapping without any problems.
    public CandiesResponse getAllCandies() {
        return callApi("/candy", CandiesResponse.class);
    }

    public Candy getACandy(Integer id) {
        return callApi("/candy/" + id, Candy.class);
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
        HttpEntity <String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(baseUrl + path, HttpMethod.GET, entity, responseType).getBody();
    }
}
