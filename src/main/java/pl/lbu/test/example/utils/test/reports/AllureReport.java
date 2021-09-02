package pl.lbu.test.example.utils.test.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static java.lang.String.format;

public class AllureReport extends Reports implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        logToConsole(format("%s %s %s", "Test class", result.getInstance(), " has started"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //TODO
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //TODO
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //TODO
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //TODO
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //TODO
    }

    @Override
    public void onStart(ITestContext context) {
        //TODO
    }

    @Override
    public void onFinish(ITestContext context) {
        //TODO
    }
}
