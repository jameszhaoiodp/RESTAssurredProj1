import static  io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    void test(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("status code: " + response.getStatusCode());
        System.out.println("content type: " + response.getHeader("content-type"));
        System.out.println("body: " + response.getBody().asString());
        System.out.println("time: " + response.getTime());

        int statusCode =response.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }

    @Test
    void test2(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }

    @Test(priority = 1)
    void setup(){
        System.out.println(" i am inside setup.");
    }
    @Test(priority = 2)
    void testSteps(){
        System.out.println("inside testSteps");
    }

    @Test(priority = 3)
    void tearDown(){
        System.out.println("inside tearDown");
    }
}
