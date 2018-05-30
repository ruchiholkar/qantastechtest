package com.qantas.test.steps;

import com.qantas.test.library.ReadPropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class LightBulbAPITestSteps {
    @Steps
    LightBulbAPITestSteps lightBulbAPITestStep;

    private Properties prop;
    private int statusCode;
    private int power;
    private Response response;

    public LightBulbAPITestSteps() {
        prop = ReadPropertiesFile.getProperty();
        RestAssured.baseURI = prop.getProperty("lightBulbApiURI");
        this.power = 60;//Default
    }

    @Step
    public void sendPostRequestwith(String onOrOff) {
        //String apiURL = prop.getProperty("lightBulbApiURI") + on;
        System.out.println("Switching " + onOrOff);
        String jsonBody = "{ \"power\" : " + this.power + " }";
        System.out.println("jsonBody " + jsonBody);
        Header h1= new Header("userid", "14e53647-e458-ce94-6ffc-69d43fd822eb");
        Header h2 = new Header("content-type", "application/json");
        Header h3 = new Header("accept-encoding", "gzip, deflate");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        Headers headers = new Headers(list);
        response = RestAssured.given().
                               contentType(ContentType.JSON).
                               //header(new Header("userid","1")).
                               //header(new Header("content-type","application/json")).
                               headers(headers).
                               body(jsonBody).
                               post(onOrOff);
        setStatusCode(response.getStatusCode());
        System.out.println("Response " + response.getBody().asString());
        System.out.println("Status code " + this.statusCode);
    }

    @Step
    public int getStatusCode(){
        return this.statusCode;
    }

    private void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    @Step
    public void setPower(int power) {
        this.power = power;
    }

    @Step
    public void sendPostRequestWithAllMethods() {
        String apiURL = prop.getProperty("lightBulbApiURI");
        response = RestAssured.given().
                contentType("application/json").
                header("content-type","application/json").
                header("accept","*/*").
                post(apiURL);
        setStatusCode(response.getStatusCode());
    }

    @Step
    public boolean verifyItReturnsAllMethods() {
        System.out.println("Response " + response.getBody().asString());
        System.out.println("Status code " + this.statusCode);
        return response.getBody().asString().contains("Example: {");
    }
}
