package com.plaetpop.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.chrome.ChromeOptions;

public class JenkinsHomepageTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        
        System.out.println("hi world");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver.exe");
        System.out.println("chromedriver Passed");
        WebDriverManager.chromedriver().setup();   

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new");
        options.addArguments("window-size=1280x800");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setBinary("/usr/bin/google-chrome");
        //options.setExperimentalOption("useAutomationExtension", false);
        
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
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
