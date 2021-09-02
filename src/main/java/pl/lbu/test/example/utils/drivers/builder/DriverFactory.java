package pl.lbu.test.example.utils.drivers.builder;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.lbu.test.example.utils.drivers.options.DriverOptions;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class DriverFactory {
    public synchronized WebDriver createDriver(DriverManagerType type, DriverOptions options) {
        switch (type) {
            case CHROME:
                if (options.getNodeUrl().isEmpty()) {
                    ChromeDriverManager.getInstance(type).driverVersion(options.getVersion()).setup();
                    return new ChromeDriver((ChromeOptions) options.getOptions());
                } else {
                    try {
                        return new RemoteWebDriver(new URL(options.getNodeUrl()), (ChromeOptions) options.getOptions());
                    } catch (MalformedURLException e) {
                        log.error(e.getMessage());
                    }
                }
            default:
                throw new WebDriverManagerException("Invalid DriverManagerType");
        }
    }
}
