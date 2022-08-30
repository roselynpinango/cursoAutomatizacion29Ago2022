package Edit.EducacionIT27Jul2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	// Variables de uso general (Globales)
	String url = "http://automationpractice.com";
	String firefoxDriver = "..\\EducacionIT27Jul2022\\Drivers\\geckodriver.exe";
	String chromeDriver = "..\\EducacionIT27Jul2022\\Drivers\\chromedriver.exe";
	
	// Método de Prueba - Buscar una palabra en la página AutomationPractice.com
	@Test
	public void buscarPalabra() {
		// Paso 1: Indicar dónde está el driver.exe que quiero usar
		System.setProperty("webdriver.gecko.driver", firefoxDriver);
		
		// Paso 2: Abrir el navegador en la página de prueba
		WebDriver browser = new FirefoxDriver(); // WebDriver representa al navegador
		browser.get(url); // Abrir el navegador en la página indicada
		
		// Paso 3: Escribir la palabra que quiero buscar
		WebElement txtBuscador = browser.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Simular que presionamos la tecla Enter
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		browser.close();
	}
	
	@Test
	public void buscarPalabraChrome() {
		// Paso 1: Indicar dónde está el driver.exe que quiero usar
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		
		// Paso 2: Abrir el navegador en la página de prueba
		WebDriver browser = new ChromeDriver(); // WebDriver representa al navegador
		browser.get(url); // Abrir el navegador en la página indicada
		
		// Paso 3: Escribir la palabra que quiero buscar
		WebElement txtBuscador = browser.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Simular que presionamos la tecla Enter
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		
	}
}
