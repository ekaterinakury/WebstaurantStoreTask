package com.webst.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        dryRun = false,
        plugin = {"html:target/cucumber-reports.html", "rerun:target/rerun.txt","json:target/cucumber-report.json"},
        features = "src/test/resources/features",
        glue = "com/webst/step_definitions",
        tags = "@test"
)

public class TestRunner {}