package de.dhbw.tinf11b2.ofk.tests;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "json:target/report.json" })
public class RunTests {

}
