package pl.lbu.test.example.utils.drivers.builder;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pl.lbu.test.example.utils.drivers.listener.EventListener;
import pl.lbu.test.example.utils.drivers.options.ChromeOption;
import pl.lbu.test.example.utils.drivers.options.DriverOptions;
import pl.lbu.test.example.utils.drivers.options.StandardOptions;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static ThreadLocal<EventFiringWebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<Locale> languages = new ThreadLocal<>();
    private static EventListener eventListener = new EventListener();

    private Driver() {

    }

    public static NeedDriver builder() {
        return new Builder();
    }

    public static class Builder implements NeedDriver, OptionalBrowserOptions, Build {

        private DriverManagerType type;
        private DriverOptions options;
        private int implicitlyWait;
        private int pageLoadTimeout = 60;
        private String url = "https://www.google.com/";
        private Locale baseLocal = new Locale("pl", "PL");

        @Override
        public Builder setDriver(DriverManagerType type) {
            this.type = type;
            return this;
        }

        @Override
        public Builder setDriver(String type) {
            for (DriverManagerType types : DriverManagerType.values()) {
                if (types.toString().toLowerCase().contains(type.toLowerCase())) {
                    setDriver(types);
                    break;
                }
            }

            if (null == this.type) {
                throw new WebDriverException("Incorrect browser name \n correct: chrome, edge, firefox");
            }
            return this;
        }

        @Override
        public Builder setExternalDriver(WebDriver webDriver) {
            EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
            drivers.set(eventFiringWebDriver);
            drivers.get().register(eventListener);
            return this;
        }

        @Override
        public EventFiringWebDriver getDriver(DriverManagerType type) {
            //TODO
            throw new RuntimeException("NOT IMPLEMENTED");
        }

        @Override
        public EventFiringWebDriver getDriver() {
            return drivers.get();
        }

        @Override
        public NeedDriver closeDriver(boolean close) {
            if (close) {
                drivers.get().unregister(eventListener);
                drivers.get().quit();
                drivers.remove();
                languages.remove();
            }
            return this;
        }

        @Override
        public Builder browserOption(DriverOptions options) {
            this.options = options;
            return this;
        }

        @Override
        public Builder browserOption(StandardOptions standardOptions) {
            switch (this.type) {
                case CHROME:
                    this.options = new ChromeOption(standardOptions).setDefaultOptions();
                    break;
            }
            return this;
        }

        @Override
        public Builder implicitlyWait(int seconds) {
            this.implicitlyWait = seconds;
            return this;
        }

        @Override
        public Builder pageLoadTimeout(int seconds) {
            this.pageLoadTimeout = seconds;
            return this;
        }

        @Override
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public Builder language(Locale locale) {
            if (null != locale) {
                languages.set(locale);
            } else {
                languages.set(baseLocal);
            }
            return this;
        }

        @Override
        public Builder build(boolean open) {
            if (open) {
                EventFiringWebDriver eventFiringWebDriver = new DriverManufacture(new DriverFactory()).setDriver(this.type, this.options);
                eventFiringWebDriver.manage().timeouts().implicitlyWait(this.implicitlyWait, TimeUnit.SECONDS);
                eventFiringWebDriver.manage().timeouts().pageLoadTimeout(this.pageLoadTimeout, TimeUnit.SECONDS);
                drivers.set(eventFiringWebDriver);
                drivers.get().register(eventListener);
                drivers.get().navigate().to(this.url);
            }
            return this;
        }
    }

    public interface NeedDriver {
        Builder setDriver(DriverManagerType type);

        Builder setDriver(String type);

        Builder setExternalDriver(WebDriver webDriver);

        EventFiringWebDriver getDriver(DriverManagerType type);

        EventFiringWebDriver getDriver();

        NeedDriver closeDriver(boolean close);
    }

    public interface OptionalBrowserOptions {
        Builder browserOption(DriverOptions options);

        Builder browserOption(StandardOptions options);

        Builder implicitlyWait(int seconds);

        Builder pageLoadTimeout(int seconds);

        Builder url(String url);

        Builder language(Locale locale);
    }


    public interface Build {
        Builder build(boolean open);
    }
}
