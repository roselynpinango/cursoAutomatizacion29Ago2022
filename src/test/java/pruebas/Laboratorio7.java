package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio7 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT27Jul2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=3)
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo01@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		login.hacerClickEnLogin();
		
		// login.ingresarCredencialesLogin("correo01@gmail.com", "1q2w3e4r5t");
	}
	
	@Test(priority=1)
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerBusqueda();
	}
	
	@Test(priority=2)
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnContactUs();
		
		PaginaContactUs contactUs = new PaginaContactUs(driver);
		contactUs.seleccionarSubject("Customer service");
		contactUs.escribirEmail("correo01@gmail.com");
		contactUs.escribirOrder("11A");
		contactUs.adjuntarArchivo("C:\\addIntegerData.txt");
		contactUs.escribirMessage("Mensaje de Contacto");
		contactUs.hacerClickEnSend();
	}
}
