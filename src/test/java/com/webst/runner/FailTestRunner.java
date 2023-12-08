package com.webst.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "@target/rerun.txt",
        glue = "com/webst/step_definitions"
)

public class FailTestRunner {}
