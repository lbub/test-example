package pl.lbu.test.example.frontend;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.utils.test.reports.AllureReport;


@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to")
public class SimpleTest extends AbstractTestNGSpringContextTests {
    private SoftAssert softAssert;

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void example() {
        softAssert.assertEquals(2, 2);
        softAssert.assertAll();
    }
}
