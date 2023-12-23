package com.demo.init.components;

import io.smart.browser.factory.impls.SeleniumBrowser;
import io.smart.enums.BrowserType;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import static com.demo.ConfigurationBuilder.buildChromeConf;


@Getter
@Component
public class BrowserSetup {
    private WebDriver driver;
    private Actions actions;

    public BrowserSetup() {
        SeleniumBrowser factory = new SeleniumBrowser().setUp(BrowserType.CHROME, buildChromeConf());
        driver = factory.getDriver();
        actions = new Actions(driver);
    }

}