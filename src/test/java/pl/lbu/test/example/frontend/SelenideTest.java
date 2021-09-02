package pl.lbu.test.example.frontend;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.google.selenide.dialog.DialogPage;
import pl.lbu.test.example.google.selenide.home.HomePage;
import pl.lbu.test.example.google.selenium.home.HomeData;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(SelenideTest.class)
@SpringBootTest(classes = TestExampleApp.class)
public class SelenideTest implements BeforeAllCallback {

    @Autowired
    private HomeData homeData;

    private SoftAssert softAssert = new SoftAssert();

    @Test
    void googleSelenide() {
        open("https://www.google.com/");
        HomePage homePage = new DialogPage().accept();
        homePage.searchValue(homeData.getSearch());
        softAssert.assertEquals(homePage.isMenu(), true);
        softAssert.assertAll();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Configuration.headless = true;
        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", true);
        options.put("enableLog", true);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("93.0");
        capabilities.setCapability("selenoid:options", options);
        Configuration.browserCapabilities = capabilities;
    }

}