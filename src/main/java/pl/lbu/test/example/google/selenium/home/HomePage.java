package pl.lbu.test.example.google.selenium.home;

public class HomePage {

    private HomeElements homeElements;

    public HomePage() {
        homeElements = new HomeElements();
    }

    public HomePage searchValue(String searchValue) {
        homeElements.searchInp.sendKeys(searchValue);
        homeElements.searchBtn.click();
        return this;
    }

    public boolean isMenu() {
        return homeElements.menu.isDisplayed();
    }
}
