package com.candyshop.storage;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.candyshop.storage.entity.Candy;
import com.candyshop.storage.entity.CandyResponse;
import com.candyshop.storage.entrypoint.CandyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(PactConsumerTestExt.class) //PactConsumer approach
@PactTestFor(providerName = "application-candy") //Given provider.
public class StorageConsumerPactTest {

    @Autowired
    private CandyService candyService;


    @Pact(consumer = "application-storage")
    public RequestResponsePact allCandies(PactDslWithProvider builder) {
        return builder
                // given("") => state
                .given("Should Provide a List of Candy")
                .uponReceiving("get all candies")
                .path("/candy")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .minArrayLike("candies", 1, 1)
                                .integerType("id", 1) // add name
                                .closeObject()
                                .closeArray()
                )
                .toPact();
    }

    @Pact(consumer = "application-storage")
    public RequestResponsePact aCandy(PactDslWithProvider builder) {
        return builder
                .given("Should Provide a Candy information of id 1", "id", 1)
                .uponReceiving("get a candy")
                .path("/candy/1")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .integerType("id", 1) // add name
                )
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "allCandies")
    void shouldReturnAllCandies(MockServer mockServer) {
        candyService.setBaseUrl(mockServer.getUrl());
        CandyResponse value = candyService.getAllCandies();
        Assertions.assertEquals(1, value.getCandies().size());
        Assertions.assertEquals(1, value.getCandies().get(0));
    }

    @Test
    @PactTestFor(pactMethod = "aCandy")
    void shouldReturnACandy(MockServer mockServer) {
        candyService.setBaseUrl(mockServer.getUrl());
        Candy value = candyService.getACandy(1);
        Assertions.assertEquals(1, value.getId());
        //validate the name as well
    }
}
