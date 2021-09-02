package pl.lbu.test.example.google.selenium.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.lbu.test.example.utils.drivers.builder.Driver;

public class HomeElements {

    public HomeElements() {
        PageFactory.initElements(Driver.builder().getDriver(), this);
    }

    @FindBy(xpath = ".//input[@name='q']")
    public WebElement searchInp;

    @FindBy(xpath = ".//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")
    public WebElement searchBtn;

    @FindBy(id = "hdtb-msb")
    public WebElement menu;
}
