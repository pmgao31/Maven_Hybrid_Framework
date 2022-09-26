package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(how=How.ID ,id ="inputEmail")
	WebElement txtusername;
	
	@FindBy(how=How.ID ,id = "inputPassword")
	WebElement txtpwd;
	
	@FindBy(how=How.NAME ,name = "button")
	WebElement txtSignInbtn;

	public void setUsername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setPassword(String uname) {
		txtpwd.sendKeys(uname);
	}

	public void ClickSignInbtn() {
		txtSignInbtn.click();
		
	}
}