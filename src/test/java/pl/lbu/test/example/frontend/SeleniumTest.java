package pl.lbu.test.example.frontend;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.google.selenium.dialog.DialogPage;
import pl.lbu.test.example.google.selenium.home.HomeData;
import pl.lbu.test.example.google.selenium.home.HomePage;
import pl.lbu.test.example.utils.drivers.builder.Driver;
import pl.lbu.test.example.utils.drivers.options.StandardOptions;
import pl.lbu.test.example.utils.test.reports.AllureReport;

@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to selenium")
@Log4j2
public class SeleniumTest extends AbstractTestNGSpringContextTests {

    private SoftAssert softAssert;

    @Autowired
    private HomeData homeData;

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
    public void selenium() {
        HomePage homePage = new DialogPage().accept();
        homePage.searchValue(homeData.getSearch());
        softAssert.assertEquals(homePage.isMenu(), true);
        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver() {
        Driver.builder().closeDriver(true);
    }
}
