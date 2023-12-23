package com.demo.init;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.demo.init.components.BrowserSetup;
import com.demo.page.Search;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.smart.browser.factory.BrowserFactory;
import io.smart.driver.DriverOperation;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = {BrowserSetup.class, Search.class})
public class Hook extends BaseTest {

    public Hook() {
    }

    @Autowired
    private BrowserSetup browserSetup;


    @Before(order = 0)
    public void setComponents(Scenario scenario) {
        driver = browserSetup.getDriver();
        super.setComponents(driver, scenario);
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()){
            String png=(String) browser.takeScreenshot(OutputType.BASE64);
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(png).build());
        }
        driver.quit();
    }


}
