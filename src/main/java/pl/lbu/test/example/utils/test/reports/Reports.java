package pl.lbu.test.example.utils.test.reports;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class Reports {
    private static final Logger LOGGER = LogManager.getLogger(Reports.class.getName());

    @Step("Log to console:\n {message}")
    static void logToConsole(String message) {
        LOGGER.info(message);
    }
}
