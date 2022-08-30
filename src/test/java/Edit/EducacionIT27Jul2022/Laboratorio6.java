package Edit.EducacionIT27Jul2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio6 {
	String url = "http://automationpractice.com";
	String chromeDriver = "..\\EducacionIT27Jul2022\\Drivers\\chromedriver.exe";
	String firefoxDriver = "..\\EducacionIT27Jul2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void abrirPagina(String navegador) {
		if (navegador.equalsIgnoreCase("chrome")) {		// Si el navegador es igual a "chrome"
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			driver = new ChromeDriver();
		} else { 										// en caso contrario
			System.setProperty("webdriver.gecko.driver", firefoxDriver);
			driver = new FirefoxDriver();
		}
			
		driver.get(url);
	}
	
	@Test
	public void buscarPalabra() {
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
	}
}
