package bdd.com.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;


public class RequestPOST implements IRequest{

    @Override
    public Response send(RequestInformation requestInformation) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestInformation.getBody())
                .when()
                .post(requestInformation.getUrl());
        response.then().log().all();
        return response;

    }
}
