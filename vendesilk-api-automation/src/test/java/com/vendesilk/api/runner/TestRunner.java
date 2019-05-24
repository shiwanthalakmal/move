package com.vendesilk.api.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/vendesilk/api/features"},
        glue = {"com.vendesilk.api.base", "com.vendesilk.api.step_definitions"},
        format = {"pretty", "json:target/cucumber.json"},
        tags = {"@Smoke"},
        monochrome = true
)
public class TestRunner {
}
