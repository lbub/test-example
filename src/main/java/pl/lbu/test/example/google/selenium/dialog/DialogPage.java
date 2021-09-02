package pl.lbu.test.example.google.selenium.dialog;

import pl.lbu.test.example.google.selenium.home.HomePage;

public class DialogPage {
    private DialogElements dialogElements;

    public DialogPage() {
        dialogElements = new DialogElements();
    }

    public HomePage accept() {
        dialogElements.accept.click();
        return new HomePage();
    }
}
