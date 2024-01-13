package com.demo.init;

import io.cucumber.java.Scenario;
import io.smart.element.impls.ElementByXpath;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

public class BaseTest {

    @Value("${portal.url}")
    private String url;

    @Value("${portal.port}")
    private String  port;

    @Value("${portal.username}")
    private String userName;

    @Value("${portal.password}")
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
