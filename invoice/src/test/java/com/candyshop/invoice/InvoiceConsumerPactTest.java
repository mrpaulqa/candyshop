package com.candyshop.invoice;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.candyshop.invoice.entity.Candy;
import com.candyshop.invoice.entity.CandyResponse;
import com.candyshop.invoice.entrypoint.CandyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(PactConsumerTestExt.class) //PactConsumer approach
@PactTestFor(providerName = "application-storage") //Given provider.
public class InvoiceConsumerPactTest { // rename this file to StorageConsumerPactTest
    @Autowired
    private CandyService candyService;

    @Pact(consumer = "application-invoice")
    public RequestResponsePact borrowItem(PactDslWithProvider builder) {
        return builder
                .given("Should borrow 10 units from item id 1")
                .uponReceiving("id 1 and an amount")
                //   /storage/{id}/borrow/{amount} /GET   /PUT   /PATCH
                //   /storage/borrow/{id}/{amount} /GET   /PUT   /PATCH
                //   /storage/borrow               /POST
                //          id = 1
                //          amount = 10
                //  /storage/{id}                  /PUT
                //          id = 1
                //          amount = 10
                //  /storage                       /PUT
                //          id = 1
                //          amount = 10
                //          method = borrow
                .path("/storage/i/borrow/10")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .integerType("id", 10)
                                .stringType("name","pactName") // reserved amount or borrow
                )
                .toPact();
    }

    // Add new states
    //    - verify if the id exists or not
    //    - if id has sufficient amount to be borrow

    // Friendly reminder to see where this goes.
    @Pact(consumer = "application-invoice")
    public RequestResponsePact candyCompositionById(PactDslWithProvider builder) {
        return builder
                // given("") => state
                .given("Should Provide composition and id for Candy","id",1)
                .uponReceiving("get candy id and composition")
                .path("/candy/10/composition")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .integerType("id", 10)
                                .stringType("name","pactName")
                                .stringType("composition","compositionPact")

                )
                .toPact();
    }
    @Test
    @PactTestFor(pactMethod = "candyCompositionById")
    void getCandyComposition(MockServer mockServer) {
        candyService.setBaseUrl(mockServer.getUrl());
        Candy value = candyService.getCandyComposition(10);
        Assertions.assertEquals(10, value.getId());
        Assertions.assertEquals("pactName", value.getName());
        Assertions.assertEquals("compositionPact", value.getComposition());


    }


}
