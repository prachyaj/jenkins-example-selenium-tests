package com.plaetpop.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsHomepageTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        
        System.out.println("hi world");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.setBinary("/usr/bin/google-chrome");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void test() {
        driver.get("https://www.jenkins.io/");
        Assertions.assertEquals("Jenkins", driver.getTitle());
    }
}
