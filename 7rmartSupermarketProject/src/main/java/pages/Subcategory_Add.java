package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

import utilities.Fileupload_Utility;
import utilities.Page_Utility;

public class Subcategory_Add {
	public WebDriver driver;

	public Subcategory_Add(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newclick;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement file;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement clicksave;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement alertt;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbutton;

	public Subcategory_Add userisabletoclicknewbutton() {
		newclick.click();
		return this;
	}

	public Subcategory_Add userisabletoselectcategoryfield() {
		category.click();
		Page_Utility page = new Page_Utility();
		page.selectByIndex(category, 3);
		return this;
	}

	public Subcategory_Add userisabletoentersubcategory(String subcategoryname) {
		subcategory.sendKeys(subcategoryname);
		return this;
	}

	public Subcategory_Add userisabletouploadimage() {
		String imagepath = Constant.TESTIMAGEFORSUBCATEGORY;
		Fileupload_Utility file1 = new Fileupload_Utility();
		file1.sendKeysUpload(file, imagepath);
		return this;
	}

	public Subcategory_Add userisabletoclicksavebutton() {
		clicksave.click();
		return this;
	}

	public boolean isalertDisplayed() {
		return alertt.isDisplayed();
	}

	public Subcategory_Search userisabletoclicksearchbutton() {
		searchbutton.click();
		return new Subcategory_Search(driver);
	}
}
