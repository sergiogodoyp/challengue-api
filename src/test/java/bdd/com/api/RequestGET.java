package bdd.com.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest {

    @Override
    public Response send(RequestInformation requestInformation) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id",requestInformation.getId())
                .when()
                .get(requestInformation.getUrl());
        response.then().log().all();
        return response;
    }
}
