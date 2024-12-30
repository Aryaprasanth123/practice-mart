package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utility;

public class Adminuser_Add {
	public WebDriver driver;

	public Adminuser_Add(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknew;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement UserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement failAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbtn;

	public Adminuser_Add userisabletoclickcreateNew() {
		clicknew.click();
		return this;
	}

	public Adminuser_Add userisabletoenterUsername(String usernamefield) {
		username.sendKeys(usernamefield);
		return this;
	}

	public Adminuser_Add userisabletoenterPassword(String passwordfield) {
		password.sendKeys(passwordfield);
		return this;
	}

	public Adminuser_Add userisabletoselectUsertype() {
		UserType.click();
		Page_Utility page = new Page_Utility();
		page.selectByIndex(UserType, 2);
		return this;

	}

	public Adminuser_Add userisabletoclickSave() {
		save.click();
		return this;
	}

	public boolean greenAlertisdisplayed() {
		return successalert.isDisplayed();
	}

	public boolean redAlertisdisplayed() {
		return failAlert.isDisplayed();
	}

	public Adminuser_Search userisabletoclicksearchbutton() {
		searchbtn.click();
		return new Adminuser_Search(driver);
	}

}
