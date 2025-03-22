package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Utilities {

    AppiumDriverLocalService service;
    String url;
    public WebDriver driver;

    public void setPreparation() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "EIUKJNAE557TOJ8T");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        driver= new AndroidDriver(new URL(url), capabilities);
    }

    public void startServer(){
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        url=service.getUrl().toString();
    }

    public void stopServer(){
        if(service.isRunning())
        {
            service.stop();
        }
    }

}