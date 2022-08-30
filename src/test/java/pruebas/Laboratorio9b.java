package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Laboratorio9b {
	String url = "https://demo.guru99.com/test/table.html";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void leerValoresTabla() {
		WebElement valor = driver.findElement(By.xpath("//tbody/tr[2]/td[1]"));
		System.out.println("Valor de Fila 2, Columna 1: " + valor.getText());
	}
}
