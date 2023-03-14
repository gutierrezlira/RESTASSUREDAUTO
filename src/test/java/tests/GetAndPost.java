package tests;

import jdk.jfr.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetAndPost {

    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";
        given().
                get("users?page=2").
                then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost() {

        Map<String, Object> map = new HashMap<String, Object>();

        //map.put("name", "Alina");
        //map.put("job", "AQA");

        //System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name", "Alina");
        request.put("job", "AQA");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201)
                .log().all();
    }
}
