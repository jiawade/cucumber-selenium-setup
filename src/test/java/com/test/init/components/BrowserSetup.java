package com.test.init.components;

import io.smart.browser.factory.impls.SeleniumBrowser;
import io.smart.enums.BrowserType;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;



@Getter
@Component
public class BrowserSetup {
    private WebDriver driver;
    private Actions actions;

    public BrowserSetup() {
//        SeleniumBrowser factory = new SeleniumBrowser().setUp(BrowserType.CHROME, buildChromeConf());
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

}