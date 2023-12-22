package com.test.init;

import com.google.common.collect.Lists;
import io.cucumber.java.Scenario;
import io.smart.browser.configuration.impls.ChromeConfiguration;
import io.smart.element.impls.ElementByXpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseTest {

    @Value("portal.url")
    private String url;

    @Value("portal.port")
    private String  port;

    @Value("portal.username")
    private String userName;

    @Value("portal.password")
    private String passWord;

    protected Scenario scenario;

    protected static ElementByXpath browser;

    public WebDriver driver;

    protected void setComponents(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
        browser = new ElementByXpath(driver);
    }


}
