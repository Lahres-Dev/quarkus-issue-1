package com.github.lahresdev;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.server.KeycloakTestResourceLifecycleManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

@QuarkusTestResource(KeycloakTestResourceLifecycleManager.class)
@TestHTTPEndpoint(HelloService.class)
@QuarkusTest
class HelloServiceTest {

    @Test
    void addiereListenNachKategorie() {
        RestAssured.with()
                .given()
                .auth()
                .oauth2(KeycloakTestResourceLifecycleManager.getAccessToken("alice"))
                .contentType(ContentType.JSON)
                .get()
                .then()
                .statusCode(200);
    }

}