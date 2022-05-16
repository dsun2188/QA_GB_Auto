package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class MyFirstTest {

    @Test
    public void checkEmptyEmail() throws Exception {
// Устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
// Проверьте актуальность пути до приложения на своём компьютере.
        capabilities.setCapability("app",
                "/Users/Sune4ka/Downloads/Android-NativeDemoApp-0.2.1.apk");
// Пример для предустановленного приложения.
// capabilities.setCapability("appPackage", "com.google.android.apps.maps");
// capabilities.setCapability("appActivity","com.google.android.maps.MapsActivity");
// capabilities.setCapability("noReset", true);
// Устанавливаем и открываем приложение.
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
// Нажимаем Login в меню
        Thread.sleep(2000);
        MobileElement loginMenuButton = (MobileElement)
                driver.findElementByXPath("//android.widget.Button[@content-desc=\"Login\"]/android.widget.TextView");
        loginMenuButton.click();
        Thread.sleep(2000);
// Нажимаем Login на странице логин/пароль.
        MobileElement loginButton = (MobileElement)
                driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup/android.widget.TextView");
        loginButton.click();
        Thread.sleep(2000);
// Проверяем текст ошибки.
        MobileElement errorText = (MobileElement)
                driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorText.getText(), "Please enter a valid email address");
// Проверяем текст ошибки #2 HW.
       MobileElement errorText2 = (MobileElement)
                driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
        Assert.assertEquals(errorText2.getText(), "Please enter at least 8 characters");
    }
}

