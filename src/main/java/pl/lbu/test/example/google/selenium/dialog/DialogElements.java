package pl.lbu.test.example.google.selenium.dialog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.lbu.test.example.utils.drivers.builder.Driver;

public class DialogElements {

    public DialogElements() {
        PageFactory.initElements(Driver.builder().getDriver(), this);
    }

    @FindBy(xpath = ".//div[@role='dialog']//button[@id='L2AGLb']")
    public WebElement accept;

}
