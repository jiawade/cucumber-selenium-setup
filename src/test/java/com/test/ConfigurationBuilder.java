package com.test;

import com.google.common.collect.Lists;
import io.smart.browser.configuration.impls.ChromeConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigurationBuilder {
    public static ChromeConfiguration buildChromeConf() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-extensions", "--disable-dev-shm-usage");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        Map<String, Boolean> infoBar = Lists.newArrayList("profile.password_manager_enabled", "credentials_enable_service").stream().collect(Collectors.toMap(i -> i, i -> false));
        options.setExperimentalOption("prefs", infoBar);
        return ChromeConfiguration.builder()
                .chromeOptions(options)
                .width(1920)
                .height(1080)
                .duration(Duration.ofSeconds(60))
                .build();
    }

}
