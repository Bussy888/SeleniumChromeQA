package ejercicioParcial2.api4.factoryRequest;

import ejercicioParcial2.api4.Configuration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        Response response = given()
                .auth()
                .preemptive()
                .basic(Configuration.user, Configuration.password)
                .body(requestInfo.getBody())
                .log()
                .all().
                when()
                .post(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }

    @Override
    public Response sendWithToken(RequestInfo requestInfo) {
        Response response = given()
                .header("Token", Configuration.token) // Add the token
                .body(requestInfo.getBody())
                .log()
                .all()
                .when()
                .post(requestInfo.getUrl());

        response.then().log().all();
        return response;
    }
}