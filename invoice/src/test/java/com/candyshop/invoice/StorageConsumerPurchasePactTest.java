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
public class StorageConsumerPurchasePactTest {
    @Autowired
    private CandyService candyService;

    @Pact(consumer = "application-invoice")
    public RequestResponsePact purchaseItem(PactDslWithProvider builder) {
        return builder
                .given("Should purchase an item")
                .uponReceiving("id 8 and an amount")
                //   /storage/{id}/purchase/{amount} /GET   /PUT   /PATCH
                //   /storage/purchase/{id}/{amount} /GET   /PUT   /PATCH
                //   /storage/purchase               /POST
                //          id = 1
                //          amount = 10
                //  /storage/{id}                  /PUT
                //          id = 1
                //          amount = 10
                //  /storage                       /PUT
                //          id = 1
                //          amount = 10
                //          method = purchase
                .path("/storage/i/purchase/10")
                .willRespondWith()
                .status(200)
                .toPact();
    }

    // Add states
    //   - not sufficient amount to be bought
    //   - id doesn't exists
}