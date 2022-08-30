package Edit.EducacionIT27Jul2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT27Jul2022\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		// Paso 1: Inicializar el navegador
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Modo Incognito (Chrome)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); // Agregar configuraciones especiales
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(url); // abro el navegador en la url indicada
		driver.manage().window().maximize(); // Maximiza la ventana
		
		// Paso 2: Completar el correo y hacer clic en el botón
		WebElement txtEmail = driver.findElement(By.name("email_create"));
		txtEmail.sendKeys("correo" + Math.random() + "@mailinator.com");
		
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// Paso 3: Completar el Formulario - Información Personal
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Radio Button "Title"
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Ramon"); // Campo "FirstName"
		driver.findElement(By.name("customer_lastname")).sendKeys("Jimenez"); // Campo "LastName"
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r5t"); // Campo "Password"

		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("18"); // List days
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("June "); // List months
		
		Select years = new Select(driver.findElement(By.name("years")));
		years.selectByIndex(29); // List years
		
		driver.findElement(By.cssSelector("#newsletter")).click(); // Check "Newsletter"
		driver.findElement(By.xpath("//input[@id='optin']")).click(); // Check "Offers"
		
		// Paso 4: Completar el Formulario - Sección Direcciones
		driver.findElement(By.id("company")).sendKeys("ABC C.A."); // Campo Company
		driver.findElement(By.name("address1")).sendKeys("MiCalle 1000 1B"); // Campo Address
		driver.findElement(By.cssSelector("#address2")).sendKeys("Entre calles A y B"); // Campo Address2
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("CABA"); // Campo City
		
		Select states = new Select(driver.findElement(By.id("id_state")));
		states.selectByVisibleText("California"); // Lista "State"
		
		driver.findElement(By.id("postcode")).sendKeys("12345"); // Campo ZipCode
		driver.findElement(By.tagName("textarea")).sendKeys("Comentario del Usuario"); // Campo Additional Information
		driver.findElement(By.name("phone")).sendKeys("435876473"); // Campo Home Phone
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("3453453545"); // Campo Mobile Phone
		
		WebElement txtAlias = driver.findElement(By.name("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Dirección de Casa"); // Campo Alias
		
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
}
