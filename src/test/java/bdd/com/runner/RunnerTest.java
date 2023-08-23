package bdd.com.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/build/cucumber-html-report", "pretty:target/build/cucumber-pretty.txt"
        , "json:target/build/cucumber.json"},
        features = {"src/test/resources/features/"},
        stepNotifications = true,
        glue = {"bdd.com.stepdefinition"},
        tags = "@Prueba"

)

public class RunnerTest {
//    @Before
//    public void beforeHook(){
//        System.out.println("HOOK -: Before Scenario");
//    }
//
//    @After
//    public void afterHook(){
//        System.out.println("HOOK -: After Scenario");
//    }

}
