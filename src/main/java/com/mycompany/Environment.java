package com.mycompany;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Environment {

    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final String USER_NAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final int EXPLICIT_WAIT = 10;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser,String platform) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                capabilities.setBrowserName("chrome");
                break;

            case "firefox":
                capabilities.setBrowserName("firefox");
                break;

            case "safari":
                capabilities.setBrowserName("safari");
                break;

            default:
                capabilities.setBrowserName("chrome");
                break;
        }


        switch (platform) {
            case "WIN10":
                capabilities.setPlatform(Platform.WIN10);
                break;

            case "MAC":
                capabilities.setPlatform(Platform.MAC);
                break;

            default:
                capabilities.setPlatform(Platform.WIN10);
                break;
        }

        URL url = null;
        try {
            url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.set(new RemoteWebDriver(url, capabilities));

        return driver.get();
    }
}

