package bdd.com.stepdefinition;

import bdd.com.api.ConfigurationApi;
import bdd.com.api.FactoryRequest;
import bdd.com.api.RequestInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetStepDefinition {

    private Response response;
    private RequestInformation requestInformation = new RequestInformation();
    private Map<String,String> myValues= new HashMap<>();

    @Given("envio un {string} para {string} y usando el body")
    public void envioUnParaYUsandoElBody(String request, String url, String body) {
        requestInformation.setUrl(buildURL(url));
        requestInformation.setBody(replaceVariable(body));
        response = FactoryRequest.make(request).send(requestInformation);

    }


    private String buildURL(String url){
        return url.replace("CREAR_PET", ConfigurationApi.post_url)
                .replace("ACTUALIZAR_PET",ConfigurationApi.put_url)
                .replace("CONSULTAR_PET",ConfigurationApi.get_url);
    }

    private String replaceVariable(String value){
        for (String attribute:myValues.keySet()
        ) {
            value=value.replace(attribute,myValues.get(attribute));
        }
        return value;
    }

    @Then("el codigo del response es {int}")
    public void elCodigoDelResponseEs(int expectedResponseCode) {
        response.then().statusCode(expectedResponseCode);

    }

    @Given("que la api {string} esta disponible")
    public void queLaApiEstaDisponible(String url) {
        requestInformation.setUrl(buildURL(url));
    }

    @When("envio un {string} con el id {int}")
    public void envioUnConElId(String request, int id) {
        requestInformation.setId(id);
        response = FactoryRequest.make(request).send(requestInformation);
    }


    @When("envio un {string} usando el body")
    public void envioUnUsandoElBody(String request, String body) {
        requestInformation.setBody(replaceVariable(body));
        response = FactoryRequest.make(request).send(requestInformation);
    }

    @And("el response body debe tener el siguiente schema {string}")
    public void elResponseBodyDebeTenerElSiguienteSchema(String expectedSchema) {
        response.then()
                .assertThat().body(matchesJsonSchemaInClasspath(expectedSchema))
                .log()
                .all();

    }
}
