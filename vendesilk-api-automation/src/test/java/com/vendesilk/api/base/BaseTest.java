package com.vendesilk.api.base;

import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class BaseTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://services.groupkt.com";
        RestAssured.basePath = "/country/get";
    }
}
