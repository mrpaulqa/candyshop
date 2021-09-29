package com.candyshop.customerscrud;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.candyshop.customerscrud.entity.Membership;
import com.candyshop.customerscrud.entity.MembershipResponse;
import com.candyshop.customerscrud.entrypoint.MembershipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(PactConsumerTestExt.class) //PactConsumer approach
@PactTestFor(providerName = "application-membership") //Given provider.
public class CustomersConsumerPactTest {
    @Autowired
    private MembershipService membershipService;

    @Pact(consumer = "application-consumer")
    public RequestResponsePact allMembership(PactDslWithProvider builder) {
        return builder
                // given("") => state
                .given("Should Provide a List of Membership")
                .uponReceiving("get all membership")
                .path("/membership")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .minArrayLike("membership", 1, 1)
                                .integerType("id", 1)
                                .stringType("label","label")
                                .closeObject()
                                .closeArray()
                )
                .toPact();

    }
    @Pact(consumer = "application-consumer")
    public RequestResponsePact aMembership(PactDslWithProvider builder) {
        return builder
                .given("Should Provide a Membership information of id 1", "id", 1)
                .uponReceiving("get a candy")
                .path("/membership/1")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .integerType("id", 1)
                )
                .toPact();
    }

    @Disabled
    @Pact(consumer = "application-consumer")
    public RequestResponsePact aCandy(PactDslWithProvider builder) {
        return builder
                .given("Should Provide a Candy information of id 1", "id", 1)
                .uponReceiving("get a candy")
                .path("/membership/1")
                .willRespondWith()
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .integerType("id", 1)
                )
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "allMembership")
    void shouldReturnAllMembership(MockServer mockServer) {
        membershipService.setBaseUrl(mockServer.getUrl());
        MembershipResponse value = membershipService.getAllMembership();
        Assertions.assertEquals(1, value.getMembership().size());
        Assertions.assertEquals(1, value.getMembership().get(0).getId());
        Assertions.assertEquals("label", value.getMembership().get(0).getLabel());
    }

    @Test
    @PactTestFor(pactMethod = "aMembership")
    void shouldReturnACandy(MockServer mockServer) {
        membershipService.setBaseUrl(mockServer.getUrl());
        Membership value = membershipService.getAMembership(1);
        Assertions.assertEquals(1, value.getId());
    }
}
