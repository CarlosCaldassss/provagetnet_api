package desafioGetnet.services;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static io.restassured.RestAssured.*;
public class DesafioGetnetService {

    public void validarContratoUser(String path, String id, int statusCode){
       given()
               //.queryParam("id",id)
               //.queryParam("email", email)
               //.queryParam("first_name",first_name)
               //.queryParam("last_name",last_name)
               //.queryParam("avatar",avatar)
               .when()
               .get(path + "/" + id)
               .then()
               .statusCode(statusCode).assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/desafioGetnet/resources/jsonchemas/response-user.json")));
    }

    public void postUser(String path, int statusCode) {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                    .body(requestBody).when()
                    .post(path).then().statusCode(statusCode);
    }

    public void getUser(String path, String id, int statusCode){
        given()
              .when()
              .get(path + "/" + id)
              .then()
                .statusCode(statusCode);
    }
}
