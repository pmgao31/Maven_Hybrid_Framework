package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.val;

public class TimeSheetPage {
	WebDriver ldriver;

	public TimeSheetPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(how=How.XPATH ,xpath ="//*[@id='time_sheet_project']")
	WebElement Project;
	
	@FindBy(how=How.ID ,id ="time_sheet_hours")
	WebElement hours;


	@FindBy(how=How.ID ,id ="employee_time_sheet_entries_attributes_0_comments")
	WebElement comments;
	
	@FindBy(how=How.NAME ,name ="commit")
	WebElement Submit;
	
	

	public void setHours(String value) {
		hours.sendKeys(value);
	}
	
	public void selectProject(int value) {
		new Select(Project).selectByIndex(value);
	}
	public void setComments(String value) {
		comments.sendKeys(value);
	}
	
	public void ClickSubmit() {
		Submit.click();
		
	}
	
}
