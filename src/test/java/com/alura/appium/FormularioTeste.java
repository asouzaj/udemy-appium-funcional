package com.alura.appium;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.alura.appium.core.DriverFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/**
 * @author ajoaq
 *
 */
public class FormularioTeste

{
	public AppiumDriver driver;

	@Before
	public void iniciar_Appium() {

		driver = DriverFactory.getDriver();

	}

	
	  @Test 
	  public void preencher_campo_nome() {
	  
	  
	  
	 
	  
	  
	  MobileElement campoNome =
	  (MobileElement)driver.findElement(MobileBy.AccessibilityId("nome"));
	  
	  campoNome.sendKeys("Ademar");
	  
	  String texto = campoNome.getText();
	  
	  Assert.assertEquals("Ademar", texto);
	  
	  
	  driver=null;
	  
	  }
	  
	  
	 
	@Test
	public void escolher_opcao_combo() {

		
		// localizar combo e clicar
		 MobileElement campoNome =
				  (MobileElement)driver.findElement(MobileBy.AccessibilityId("nome"));
				  
				  campoNome.sendKeys("Ademar");

					/*
					 * MobileElement comboJogos = (MobileElement)
					 * driver.findElement(By.xpath("android.widget.Spinner"));
					 * 
					 * comboJogos.click();
					 */
				  
				
					 
					  driver.findElement(MobileBy.AccessibilityId("console")).click();
					  
					  //comboJogos.click();
					   

		// selecionar o elemento com xpath
		MobileElement comboOpcao = (MobileElement) driver
				.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']"));
		comboOpcao.click();

		// validar o elememnto com assert
		MobileElement textoOpcao = (MobileElement) driver
				.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"));

		String texto = textoOpcao.getText();
		Assert.assertEquals("PS4", texto);
		driver=null;
	}

	
	  @Test 
	  public void deve_interagir_switch_checkbox() {
	  
	  // AppiumDriver driver = AppiumDriverConfig.Instance().driver;
	  
	  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
	  //AppiumDriver driver = AppiumDriverConfig.Instance().driver;
	  
	  
	  
	  // localizar elementos switch e check 
	  MobileElement elementoChek =   (MobileElement) driver.findElement(By.xpath("//android.widget.CheckBox"));
	  MobileElement elementoSwitch = (MobileElement) driver.findElement(By.xpath("//android.widget.Switch")); 
	  
	  // verificar o status atual 
	  String statCheck = elementoChek.getAttribute("checked"); 
	  String statSwitch = elementoSwitch.getAttribute("checked");
	  Assert.assertEquals("false", statCheck); 
	  Assert.assertEquals("true",  statSwitch); 
	  
	  // clicar sobre os elememtos 
	  elementoChek.click();
	  elementoSwitch.click(); 
	  
	  // verificar novo status 
	  statCheck =   elementoChek.getAttribute("checked"); 
	  statSwitch =  elementoSwitch.getAttribute("checked"); 
	  Assert.assertNotEquals("false", statCheck); 
	  Assert.assertNotEquals("true", statSwitch);
	  
	  driver=null;
	  }
	 
	@After
	public void tearDown() {
		if (driver != null) {
			System.out.println(LocalDate.now());
			driver.quit();
			driver = null;
		}

	}

}
