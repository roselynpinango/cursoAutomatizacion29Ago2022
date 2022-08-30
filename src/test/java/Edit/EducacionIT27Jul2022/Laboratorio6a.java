package Edit.EducacionIT27Jul2022;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6a {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT27Jul2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String rutaEvidencias = "..\\EducacionIT27Jul2022\\Evidencias\\";
	String nombreDocumento = "Evidencias - AutomationPractice.docx";
	String nombreImgTemporal = "img.jpg";
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Buscar Palabra", priority=100)
	public void buscarPalabra() throws IOException {
		// Capturar pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "01_pantalla_principal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "02_palabra_a_buscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "03_resultado_busqueda.jpg"));
		
		String expectedURL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=skirt&submit_search=";
		String currentURL = driver.getCurrentUrl(); // obtener la URL
		String expectedTitle = "Search - My Store";
		String currentTitle = driver.getTitle(); // obtener el titulo
		
		Assert.assertNotEquals(url, currentURL); // Validando que la URL haya cambiado respecto a la original
		Assert.assertEquals(currentURL, expectedURL); // Validando la URL
		Assert.assertEquals(currentTitle, expectedTitle); // Validando el titulo
	}
	
	@Test(description="CP02 - Ir a Contáctanos", priority=2)
	public void irAContactUs() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(rutaEvidencias + nombreDocumento, "Documento de Evidencias", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + nombreImgTemporal, rutaEvidencias + nombreDocumento, "Pantalla Principal");
		
		driver.findElement(By.linkText("Contact us")).click(); // Entrar en Contact Us
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + nombreImgTemporal, rutaEvidencias + nombreDocumento, "Después de hacer clic en Contact Us");
		
		Select contactList = new Select(driver.findElement(By.id("id_contact")));
		contactList.selectByVisibleText("Webmaster"); // Lista de Contactos
		
		driver.findElement(By.name("from")).sendKeys("correo99@gmail.com"); // Correo 
		driver.findElement(By.cssSelector("#id_order")).sendKeys("11B"); // Order reference
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt"); // Attached File
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto"); // Message
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + nombreImgTemporal, rutaEvidencias + nombreDocumento, "Formulario Lleno");
		
		driver.findElement(By.id("submitMessage")).click(); // Boton Send
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + nombreImgTemporal, rutaEvidencias + nombreDocumento, "Después de enviar el formulario de Contacto");
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close(); // Cerrar el navegador
	}
}
