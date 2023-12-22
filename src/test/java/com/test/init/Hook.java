package com.test.init;

import com.test.init.components.BrowserSetup;
import com.test.page.Search;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
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
        driver.quit();
    }


}
