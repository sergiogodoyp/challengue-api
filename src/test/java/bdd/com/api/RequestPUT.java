package bdd.com.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPUT implements IRequest{
    @Override
    public Response send(RequestInformation requestInformation) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestInformation.getBody())
                .when()
                .put(requestInformation.getUrl());
        response.then().log().all();
        return response;
    }
}
