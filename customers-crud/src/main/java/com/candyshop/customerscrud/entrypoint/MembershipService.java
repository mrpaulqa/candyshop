package com.candyshop.customerscrud.entrypoint;

import com.candyshop.customerscrud.entity.Membership;
import com.candyshop.customerscrud.entity.MembershipResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MembershipService {
    @Autowired
    private RestTemplate restTemplate;

    // Reach out Person CandyApplication
    private String baseUrl = "http://localhost:8080/";

    //Could have get mapping without any problems.
    public MembershipResponse getAllMembership() {
        return callApi("/membership", MembershipResponse.class);
    }

    public Membership getAMembership(Integer id) {
        return callApi("/membership/" + id, Membership.class);
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
