package com.candyshop.membership;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.candyshop.membershipcrud.MembershipController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("application-membership")
@PactBroker(scheme="http", host="localhost", port="9292")
public class MembershipProviderPactTest {
    @LocalServerPort
    private int port;

    private MembershipController membershipController;

    //Binding between the contract test with our random port of springboot
    @BeforeEach
    public void setupTestTarget(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", port));
        // little discovery... 6hrs...
        System.setProperty("pact.verifier.publishResults", "true");
        System.setProperty("pact.provider.version", "0.1.0");
    }
    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    //state will be pact name defined by the consumer
    @State(value = "Should Provide a List of Membership")
    public void shouldProvideListOfMembership() {
        this.membershipController.getAll();
    }

    @State(value = "Should Provide a Candy information of id 1")
    public void shouldProvideMembership(Map<String, Object> params) {
        Integer id = Integer.parseInt(params.get("id").toString());
        this.membershipController.get(id);
    }

}
