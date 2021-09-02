package pl.lbu.test.example.google.selenide.dialog;


import pl.lbu.test.example.google.selenide.home.HomePage;

import static pl.lbu.test.example.google.selenide.dialog.DialogElements.accept;

public class DialogPage {

    public HomePage accept() {
        accept.click();
        return new HomePage();
    }
}
