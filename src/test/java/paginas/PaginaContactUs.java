package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	@FindBy(id="id_contact")
	WebElement selSubject;
	
	@FindBy(name="from")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='id_order']")
	WebElement txtOrder;
	
	@FindBy(css="#fileUpload")
	WebElement filAttached;
	
	@FindBy(tagName="textarea")
	WebElement txtMessage;
	
	@FindBy(id="submitMessage")
	WebElement btnSend;
	
	public PaginaContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubject(String texto) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(texto);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrder(String order) {
		txtOrder.sendKeys(order);
	}
	
	public void adjuntarArchivo(String ruta) {
		filAttached.sendKeys(ruta);
	}
	
	public void escribirMessage(String message) {
		txtMessage.sendKeys(message);
	}
	
	public void hacerClickEnSend() {
		btnSend.click();
	}
}
