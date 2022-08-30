package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos de la página web que vamos a necesitar
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(partialLinkText="Sign out")
	WebElement lnkSignOut;
	
	// Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que podemos hacer sobre los elementos de la página
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClickEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredencialesLogin(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void hacerClicEnSignOut() {
		lnkSignOut.click();
	}
}
