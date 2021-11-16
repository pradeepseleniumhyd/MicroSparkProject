package com.microspark.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"C:\\Users\\marri\\eclipse-workspace\\MicroSpark\\src\\test\\java\\com\\microspark\\features"},
		glue= {"com.microspark.stepDef"},
		dryRun=false,
		monochrome = true,publish = true,
		plugin = {"pretty","html:target/MicroSparkReport.html","json:target/MicroSpark.json","junit:target/MicroSpark.xml"}
	//	tags = "@Careers"
		)
public class Runner {

}
