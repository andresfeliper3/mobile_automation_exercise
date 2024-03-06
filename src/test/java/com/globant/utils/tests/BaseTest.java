package com.globant.utils.tests;

import com.globant.screens.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import com.github.javafaker.Faker;


public class BaseTest {
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();
    private static final String URL = "http://127.0.0.1";
    private static final String PORT = "4723";
    private static AndroidDriver androidDriver;



    @DataProvider(name = "signUpData")
    public Object[][] getSignUpData() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new Object[][] {{email, password}};
    }
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setupCapabilities(capabilities);
        try {
            androidDriver = new AndroidDriver(new URL(URL + ":" + PORT), capabilities);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }


    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        } catch(IOException e) {
            throw new RuntimeException("Error loading propertes file " + PROPERTIES_FILE);
        }
    }

    private void setupCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setPlatformVersion(getCapability("platformVersion"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
        capabilities.setUdid(getCapability("udid"));
        capabilities.setAutomationName(getCapability("automationName"));
    }

    private String getCapability(String capabilityKey) {
        return properties.getProperty(capabilityKey);
    }

    @AfterMethod
    public void close() {
        androidDriver.quit();
    }

    public HomeScreen getHomeScreen() {
        return new HomeScreen(androidDriver);
    }



}
