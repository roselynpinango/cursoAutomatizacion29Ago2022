package pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.Alerta;

public class Laboratorio9 {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	Alerta alerta;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		alerta = new Alerta(driver);
	}
	
	@Test
	public void alertaNotificacion() {
		alerta.clicEnNotificacion();
		
		driver.switchTo().alert().accept(); // Hace clic en OK del pop-up
	}
	
	@Test
	public void alertaDecision() {
		alerta.clicEnDecision();
		
		driver.switchTo().alert().dismiss(); // Hace clic en Cancel del pop-up
	}
	
	@Test
	public void alertaCampoTexto() {
		alerta.clicEnCampoTexto();
		
		Alert alCampo = driver.switchTo().alert();
		alCampo.sendKeys("Clase de Automatizacion"); // escribimos en el pop-up
		alCampo.accept(); // hacer clic en OK del pop-up
	}
	
	@Test
	public void alertaDemora() {
		alerta.clicEnDemora();
		
		// espera hasta que apareca un pop-up
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept(); // hacer clic en OK del pop-up
	}
}
