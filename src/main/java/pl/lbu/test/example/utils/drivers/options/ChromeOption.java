package pl.lbu.test.example.utils.drivers.options;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.ArrayList;
import java.util.List;

public class ChromeOption implements DriverOptions<ChromeOption, ChromeOptions> {

    private StandardOptions standardOptions;
    private ChromeOptions options;

    public ChromeOption() {
        this.standardOptions = StandardOptions.builder().build();
    }

    public ChromeOption(StandardOptions standardOptions) {
        this.standardOptions = standardOptions;
    }


    @Override
    public ChromeOption standardOptions(StandardOptions standardOptions) {
        this.standardOptions = standardOptions;
        return this;
    }

    @Override
    public String getNodeUrl() {
        return this.standardOptions.getNodeUrl();
    }

    @Override
    public ChromeOption setNodeUrl(String url) {
        this.standardOptions.setNodeUrl(url);
        return this;
    }


    @Override
    public String getVersion() {
        return this.standardOptions.getDriverVersion();
    }

    @Override
    public ChromeOption setVersion(String version) {
        this.standardOptions.setDriverVersion(version);
        return this;
    }

    @Override
    public ChromeOptions getOptions() {
        return this.options;
    }

    @Override
    public ChromeOption setOptions(ChromeOptions options) {
        this.options = options;
        return this;
    }

    @Override
    public ChromeOption setDefaultOptions() {
        this.options = new ChromeOptions();
        List<String> list = new ArrayList<>();
        if (this.standardOptions.isHeadless()) {
            list.add("--headless");
        }
        if (this.standardOptions.isIncognito()) {
            list.add("--incognito");
        }

        list.add("statt-maximized");
        list.add("enable-automation");
        options.addArguments(list);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability("acceptInsecureCerts", true);
        return this;
    }

    @Override
    public ChromeOption setStandardOptions(StandardOptions standardOptions) {
        this.standardOptions = standardOptions;
        return this;
    }

    @Override
    public ChromeOption extendOptions(String additionalOptions) {
        this.options.addArguments(additionalOptions);
        return this;
    }
}
