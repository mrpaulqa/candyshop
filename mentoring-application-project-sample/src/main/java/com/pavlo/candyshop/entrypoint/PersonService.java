package com.pavlo.candyshop.entrypoint;

import com.pavlo.candyshop.entity.PeopleResponse;
import com.pavlo.candyshop.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;

    // Reach out Person Application
    private String baseUrl = "http://localhost:8080/";

    //Could have get mapping without any problems.
    public PeopleResponse getAllPeople() {
        return callApi("/person", PeopleResponse.class);
    }

    public Person getAPerson(Integer id) {
        return callApi("/person/" + id, Person.class);
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
