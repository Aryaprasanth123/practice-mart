package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooter_Page {
	public WebDriver driver;

	public ManageFooter_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")
	WebElement updateicon;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageFooter_Page userIsAbleToClickUpdateicon() {
		updateicon.click();
		return this;
	}

	public ManageFooter_Page userIsAbleToAddAddress(String addressfield) {
		address.sendKeys(addressfield);
		return this;
	}

	public ManageFooter_Page userIsAbleToAddEmail(String emailfield) {
		email.sendKeys(emailfield);
		return this;
	}

	public ManageFooter_Page userIsAbleToAddPhoneNumber(String phonenumber) {
		phone.sendKeys(phonenumber);
		return this;
	}

	public ManageFooter_Page userIsAbleToclickupdate() {
		updatebutton.click();
		return this;
	}

	public boolean isFooterTextUpdateSuccessfully() {
		return alert.isDisplayed();
	}

}
