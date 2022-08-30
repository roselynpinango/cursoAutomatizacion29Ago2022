package Edit.EducacionIT27Jul2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIt27Jul2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Buscar Palabra", priority=100)
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		String expectedURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=skirt&submit_search=";
		String currentURL = driver.getCurrentUrl(); // obtener la URL
		String expectedTitle = "Search - My Store";
		String currentTitle = driver.getTitle(); // obtener el titulo
		
		Assert.assertNotEquals(url, currentURL); // Validando que la URL haya cambiado respecto a la original
		Assert.assertEquals(currentURL, expectedURL); // Validando la URL
		Assert.assertEquals(currentTitle, expectedTitle); // Validando el titulo
	
	}
	
	@Test(description="CP02 - Ir a Contáctanos", priority=2)
	public void irAContactUs() {
		driver.findElement(By.linkText("Contact us")).click(); // Entrar en Contact Us
		
		Select contactList = new Select(driver.findElement(By.id("id_contact")));
		contactList.selectByVisibleText("Webmaster"); // Lista de Contactos
		
		driver.findElement(By.name("from")).sendKeys("correo99@gmail.com"); // Correo 
		driver.findElement(By.cssSelector("#id_order")).sendKeys("11B"); // Order reference
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt"); // Attached File
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto"); // Message
		
		driver.findElement(By.id("submitMessage")).click(); // Boton Send
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close(); // Cerrar el navegador
	}
}
