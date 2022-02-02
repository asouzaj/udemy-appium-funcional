package com.alura.appium.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    
	private static AppiumDriver driver;
    


    public static AppiumDriver getDriver(){
        if( driver == null ){
        	
        	
            createDriver();
        }
       
        return driver;
    }

    private static void createDriver() {
        //File apk = new File("C:\\Users\\ajoaq\\eclipse-workspace\\1820-appium-aula5\\src\\main\\resources\\alura_esporte.apk");
        //File apk = new File("C:\\Users\\ajoaq\\eclipse-workspace\\udemy-appium-funcional\\src\\main\\resources\\com.intelloware.apkinfo.apk");
    	//File apk = new File("C:\\Users\\ajoaq\\eclipse-workspace\\udemy-appium-funcional\\src\\main\\resources\\CTAppium_1_2.apk");
    	
    	File apk = new File("C:\\Users\\ajoaq\\eclipse-workspace\\1820-appium-aula5\\src\\main\\resources\\CTAppium_1_2.apk");
        
    	DesiredCapabilities configuracoes = new DesiredCapabilities();
    	configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        
        
       

        URL urlConexao = null;
         
        try {
            urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
            
        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
        }
       
       
        driver = new AppiumDriver<>(urlConexao,configuracoes);
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        MobileElement botaoOk = (MobileElement)driver.findElement(MobileBy.AccessibilityId("android:id/button1"));
        botaoOk.click();
       
        MobileElement botaoFormulario = (MobileElement)driver.findElement(By.xpath("//*[@text='Formulário']"));
        botaoFormulario.click();
       
        
    }
    
    public void killDriver() {
    	
    	if(driver != null) {
    	driver.quit();
    	driver = null;
    	}
    	
    }
}
