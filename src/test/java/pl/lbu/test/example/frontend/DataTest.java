package pl.lbu.test.example.frontend;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.google.selenium.home.HomeData;
import pl.lbu.test.example.utils.test.reports.AllureReport;

import static java.lang.String.format;

@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to get data for test")
@Log4j2
public class DataTest extends AbstractTestNGSpringContextTests {

    private SoftAssert softAssert;

    @Autowired
    private HomeData homeData;

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void dataFromApplicationYml() {
        log.info(format("Value %s", homeData.getSearch()));
        softAssert.assertNotNull(homeData.getSearch());
        softAssert.assertAll();
    }
}
