package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alerta {
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	@FindBy(xpath="//button[@id='timerAlertButton']")
	WebElement btnDemora;
	
	@FindBy(css="#confirmButton")
	WebElement btnDecision;
	
	@FindBy(id="promtButton")
	WebElement btnCampoTexto;
	
	public Alerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void clicEnDemora() {
		btnDemora.click();
	}
	
	public void clicEnDecision() {
		btnDecision.click();
	}
	
	public void clicEnCampoTexto() {
		btnCampoTexto.click();
	}
}
