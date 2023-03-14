package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDeleted {

    @Test
    public void testPut() {

        JSONObject request = new JSONObject();

        request.put("name", "Alina");
        request.put("job", "AQA");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200)
                .log().all();
    }

    @Test
    public void testPatch() {

        JSONObject request = new JSONObject();

        request.put("name", "Alina");
        request.put("job", "AQA");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200)
                .log().all();
    }

    @Test
    public void testDelete() {

        baseURI = "https://reqres.in";
        given().delete("/api/users/2").
                then().
                statusCode(204)
                .log().all();
    }
}
