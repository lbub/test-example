package pl.lbu.test.example.google.selenide.home;

import static pl.lbu.test.example.google.selenide.home.HomeElements.*;

public class HomePage {

    public HomePage searchValue(String searchValue) {
        searchInp.sendKeys(searchValue);
        searchBtn.click();
        return this;
    }

    public boolean isMenu() {
        return menu.isDisplayed();
    }
}
