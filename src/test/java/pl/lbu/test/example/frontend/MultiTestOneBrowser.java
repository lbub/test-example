package pl.lbu.test.example.frontend;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.utils.drivers.builder.Driver;
import pl.lbu.test.example.utils.drivers.options.StandardOptions;
import pl.lbu.test.example.utils.test.reports.AllureReport;

@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to couple test in one driver instance")
public class MultiTestOneBrowser extends AbstractTestNGSpringContextTests {

    private SoftAssert softAssert;

    @BeforeClass
    public void setDriver() {
        Driver.builder()
                .setDriver("chrome")
                .browserOption(StandardOptions.builder().build())
                .build(true);
    }

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void testOne() {
        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google");
        softAssert.assertAll();
    }

    @Test
    public void testSec() {
        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google2");
        softAssert.assertAll();
    }

    @Test
    public void testTh() {
        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google");
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver() {
        Driver.builder().closeDriver(true);
    }
}
