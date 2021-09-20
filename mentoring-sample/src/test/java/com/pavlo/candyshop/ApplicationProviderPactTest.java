package com.pavlo.candyshop;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.pavlo.candyshop.entrypoint.CandyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("mentoring-sample-provider-contract")
@PactBroker(host = "localhost", port = "9292")
public class ApplicationProviderPactTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CandyController candyController;

    @BeforeEach
    public void setupTestTarget(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", port));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State(value = "Should Provide a List of Candies")
    public void shouldProvideListOfCandies() {
        this.candyController.getAll();
    }

    @State(value = "Should Provide a Candy information of id 1")
    public void shouldProvideListOfCandies(Map<String, Object> params) {
        Integer id = Integer.parseInt(params.get("id").toString());
        this.candyController.get(id);
    }
}
