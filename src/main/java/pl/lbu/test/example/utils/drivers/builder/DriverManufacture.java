package pl.lbu.test.example.utils.drivers.builder;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pl.lbu.test.example.utils.drivers.options.DriverOptions;

public class DriverManufacture {
    private DriverFactory factory;

    public DriverManufacture(DriverFactory factory) {
        this.factory = factory;
    }

    public synchronized EventFiringWebDriver setDriver(DriverManagerType type, DriverOptions options) {
        return new EventFiringWebDriver(factory.createDriver(type, options));
    }

    public synchronized EventFiringWebDriver setDriver(DriverManagerType type) {
        return new EventFiringWebDriver(factory.createDriver(type, null));
    }
}
