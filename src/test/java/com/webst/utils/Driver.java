package com.webst.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {
    }


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    // A re-usable utility method which will return same driver instance when I call it
    public static WebDriver getDriver() {

        // It will check if driver is null and if it is I will set up browser inside if statement
        if (driverPool.get() == null) {


            String browserType = CR.getProperty("browser");

            switch (browserType) {
                case "chrome":
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    public static void quitDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
