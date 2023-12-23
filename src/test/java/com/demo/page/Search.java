package com.demo.page;

import com.demo.init.BaseTest;
import org.springframework.stereotype.Component;

@Component
public class Search extends BaseTest {

    public void openUrl(String url) {
        browser.get(url);
    }

    public void inputText(String keyWord) {
        browser.input("@name->q", keyWord);
    }

    public void clickSearchButton() {
        browser.click("@type->submit");
    }

    public void verifyOnResultsPage(){
        browser.getTitle();
    }
}
