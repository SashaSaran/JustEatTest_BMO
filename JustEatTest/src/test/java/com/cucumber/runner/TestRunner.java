package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//this class runs as a JUnit class
//it uses the file feature.feature and stepDeffinitions to run a JUnit test.
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature.feature",glue="stepDeffinitions")


public class TestRunner {

}
