package org.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/test.feature",
		glue = "org.logintest.qa",
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"html:target/cucumber-report.json"},
		monochrome = true
		)

public class Runner extends AbstractTestNGCucumberTests {

}
