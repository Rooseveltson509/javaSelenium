package fr.zenity.academy.runner;


//import fr.zenity.academy.listeners.ExtentReportListener;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "./src/test/resources/features",
                "./src/test/resources/features/ecommerce",
                "./src/test/resources/features/C_01_DEMO",
                "./src/test/resources/features/C_02_PASSANT",

        },
        glue = {"fr.zenity.academy.stepDefinitions", "fr/zenity/academy/hook"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        monochrome = true,
        dryRun = false
        //tags = ("@subscription")
)
public class TestRunner extends BaseRunner{
}
