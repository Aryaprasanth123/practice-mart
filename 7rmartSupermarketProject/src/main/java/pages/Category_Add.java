package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;

import utilities.Fileupload_Utility;

public class Category_Add {
	public WebDriver driver;

	public Category_Add(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addnewcategory;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categorynam;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[contains(@name,'main_img')]")
	WebElement choosefile;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[1]/label[2]/input")
	WebElement showOnTopmenu;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/form/div/div[4]/div[2]/label[2]/input")
	WebElement showOnLeftmenu;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebtn;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement alertt;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement clicksearch;

	public Category_Add userisabletoclicknewbutton() {
		addnewcategory.click();
		return this;
	}

	public Category_Add userisabletoentercategoryname(String categoryfield) {
		categorynam.sendKeys(categoryfield);
		return this;
	}

	public Category_Add userisabletoclickdiscount() {
		discount.click();
		return this;
	}

	public Category_Add userisabletouploadfile() {
		String imagepath = Constant.TESTIIMAGE;
		Fileupload_Utility file = new Fileupload_Utility();
		file.sendKeysUpload(choosefile, imagepath);
		return this;
	}

	public Category_Add userisabletoselecttopmenu() {
		showOnTopmenu.click();
		return this;
	}

	public Category_Add userisabletoselectleftmenu() {
		showOnLeftmenu.click();
		return this;
	}

	public Category_Add userisabletocliksave() {
		savebtn.click();
		return this;
	}

	public boolean isalertisDisplayed() {
		return alertt.isDisplayed();
	}

	public Category_Search userisabletoclicksearch() {
		clicksearch.click();
		return new Category_Search(driver);

	}
}
