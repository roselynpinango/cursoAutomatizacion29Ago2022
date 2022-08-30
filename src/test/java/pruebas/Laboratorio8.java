package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup(); // Inicializando el driver que queremos usar
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos del Login desde Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClickEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClickEnLogin();
		
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL); // Significa que el usuario se pudo loguear
	
		// Como el usuario inició sesión, necesitamos volver a la posición inicial (Sign Out)
		login.hacerClicEnSignOut();
	}
	
	@DataProvider(name="Datos del Login desde Excel")
	public Object[][] obtenerDatosLoginDesdeExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT27Jul2022\\Datos\\DataProviderExcel24Ago2022.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos del Login")
	public Object[][] obtenerDatosLogin() {
		Object[][] datos = new Object[4][2];
		
		// Primer set de datos
		datos[0][0] = "abc@gmail.com"; // Correo 
		datos[0][1] = "43r34w34"; // Contraseña
		
		// Segundo set de datos
		datos[1][0] = "def@gmail.com"; // Correo 
		datos[1][1] = "5u776ur"; // Contraseña
		
		// Tercer set de datos
		datos[2][0] = "ghi@gmail.com"; // Correo 
		datos[2][1] = "78i6t7r"; // Contraseña
		
		// Cuarto set de datos
		datos[3][0] = "jkl@gmail.com"; // Correo 
		datos[3][1] = "yeryewtw"; // Contraseña
		
		return datos;
	}
}
