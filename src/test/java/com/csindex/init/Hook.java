package com.csindex.init;

import com.csindex.init.components.HttpRequests;
import com.csindex.socket.entity.SocketTask;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;


@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = {Test.class})
public class Hook extends BaseFunctionTest {

    public Hook() {
    }


    @Autowired
    private Test test;


    @Before(order = 0)
    public void setComponents(Scenario scenario) {
        super.setComponents(socketClient, httpRequestSetup, portalService, sqlSession.getSqlSession(), scenario);
    }

    @After
    public void after(Scenario scenario) {
        showScenarioExecutionLogs(scenario);
        socketClient.close();
        sqlSession.closeSession();
        portalService.changeDataSourceDate(dataSourceDate);
    }


}
