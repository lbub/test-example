package pl.lbu.test.example.frontend;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.utils.drivers.builder.Driver;
import pl.lbu.test.example.utils.drivers.options.ChromeOption;
import pl.lbu.test.example.utils.drivers.options.StandardOptions;
import pl.lbu.test.example.utils.test.reports.AllureReport;

import java.util.ArrayList;
import java.util.List;


@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to driver")
public class DriverTest extends AbstractTestNGSpringContextTests {

    private SoftAssert softAssert;

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void chromeStandardOptions() {
        Driver.builder()
                .setDriver("chrome")
                .browserOption(StandardOptions.builder().build())
                .build(true);

        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google");
        softAssert.assertAll();
        Driver.builder().closeDriver(true);
    }

    @Test
    public void chromeExtendOptions() {
        ChromeOption chromeOption = new ChromeOption();
        chromeOption.setDefaultOptions();
        chromeOption.extendOptions("--dns-prefetch-disable");

        Driver.builder()
                .setDriver("chrome")
                .browserOption(chromeOption)
                .build(true);

        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google");
        softAssert.assertAll();
        Driver.builder().closeDriver(true);
    }

    @Test
    public void chrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        List<String> list = new ArrayList<>();
        list.add("--headless");
        list.add("--incognito");
        list.add("window-size=1980,960");
        list.add("statt-maximized");
        list.add("enable-automation");
        chromeOptions.addArguments(list);
        ChromeOption chromeOption = new ChromeOption();
        chromeOption.setOptions(chromeOptions);
        chromeOption.extendOptions("--dns-prefetch-disable");

        Driver.builder()
                .setDriver("chrome")
                .browserOption(chromeOption)
                .build(true);

        softAssert.assertEquals(Driver.builder().getDriver().getTitle(), "Google");
        softAssert.assertAll();
        Driver.builder().closeDriver(true);
    }
}
