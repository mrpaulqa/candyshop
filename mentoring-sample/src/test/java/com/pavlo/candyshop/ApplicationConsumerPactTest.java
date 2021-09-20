//package com.pavlo.candyshop;
//
//import au.com.dius.pact.consumer.MockServer;
//import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
//import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
//import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
//import au.com.dius.pact.consumer.junit5.PactTestFor;
//import au.com.dius.pact.core.model.RequestResponsePact;
//import au.com.dius.pact.core.model.annotations.Pact;
//import com.pavlo.candyshop.entity.CandiesResponse;
//import com.pavlo.candyshop.entity.Candy;
//import com.pavlo.candyshop.entrypoint.CandyConsumerController;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@ExtendWith(PactConsumerTestExt.class)
//@PactTestFor(providerName = "mentoring-sample-provider-contract")
//public class ApplicationConsumerPactTest {
//    @Autowired
//    private CandyConsumerController candyConsumerController;
//
//    @Pact(consumer = "candy-crud")
//    public RequestResponsePact allCandies(PactDslWithProvider builder) {
//        return builder
//                .given("Should Provide a List of Candies")
//                    .uponReceiving("get all candies")
//                    .path("/candy")
//                .willRespondWith()
//                    .status(200)
//                    .body(
//                            new PactDslJsonBody()
//                                    .minArrayLike("candies", 1, 1)
//                                    .integerType("id", 1)
//                                    .closeObject()
//                                    .closeArray()
//                    )
//                .toPact();
//    }
//
//    @Pact(consumer = "candy-crud")
//    public RequestResponsePact aCandy(PactDslWithProvider builder) {
//        return builder
//                .given("Should Provide a Candy information of id 1", "id", 1)
//                    .uponReceiving("get a candy")
//                    .path("/candy/1")
//                .willRespondWith()
//                    .status(200)
//                    .body(
//                            new PactDslJsonBody()
//                                    .integerType("id", 1)
//                    )
//                .toPact();
//    }
//
//    @Test
//    @PactTestFor(pactMethod = "allCandies")
//    void shouldReturnAllCandies(MockServer mockServer) {
//        candyConsumerController.setBaseUrl(mockServer.getUrl());
//        CandiesResponse value = candyConsumerController.getAllCandies();
//        Assertions.assertEquals(1, value.getCandies().size());
//        Assertions.assertEquals(1, value.getCandies().get(0).getId());
//    }
//
//    @Test
//    @PactTestFor(pactMethod = "aCandy")
//    void shouldReturnACandy(MockServer mockServer) {
//        candyConsumerController.setBaseUrl(mockServer.getUrl());
//        Candy value = candyConsumerController.getACandy(1);
//        Assertions.assertEquals(1, value.getId());
//    }
//}
