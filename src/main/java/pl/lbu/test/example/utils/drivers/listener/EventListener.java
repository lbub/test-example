package pl.lbu.test.example.utils.drivers.listener;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import static java.lang.String.format;

@Log4j2
public class EventListener implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        try {
            log.info(format("Before Alert Accept %s", webDriver.getWindowHandle()));
        } catch (UnhandledAlertException e) {
            log.warn(format("Before Alert Accept %s", webDriver.getWindowHandle()));
        }
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        log.info(format("Before Navigate To %s", s));
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        //TODO
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        //TODO
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        //TODO
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        //TODO
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        //TODO
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        //TODO
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        //TODO
    }
}
