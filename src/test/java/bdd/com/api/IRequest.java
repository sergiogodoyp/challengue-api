package bdd.com.api;

import io.restassured.response.Response;

public interface IRequest {
    Response send(RequestInformation requestInformation);
}
