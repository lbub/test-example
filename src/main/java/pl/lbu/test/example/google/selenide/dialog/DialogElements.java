package pl.lbu.test.example.google.selenide.dialog;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DialogElements {
    public static SelenideElement accept = $(byXpath(".//div[@role='dialog']//button[@id='L2AGLb']"));
}
