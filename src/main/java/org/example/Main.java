package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main {
    public static WebDriver driver;
    @BeforeTest
    @Parameters({"browser", "url"})
    public void main(String browser, String url) {
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(co);
        } else if (browser.equalsIgnoreCase("firefox")) {
            //System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else{
            System.out.println("Browser not support for test");
            System.exit(0);
        }
        driver.manage().window().maximize();

        }


    }


