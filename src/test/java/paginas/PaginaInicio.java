package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página web que vamos a necesitar
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor del objeto
	public PaginaInicio(WebDriver driver) {
		// Inicializar los elementos de la clase página
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre la página web
	public void hacerClickEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	public void hacerClickEnContactUs() {
		lnkContactUs.click();
	}
}
