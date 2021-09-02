package pl.lbu.test.example.google.selenide.home;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomeElements {
    public static SelenideElement searchInp = $(byXpath(".//input[@name='q']"));
    public static SelenideElement searchBtn = $(byXpath(".//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
    public static SelenideElement menu = $(byId("hdtb-msb"));
}
