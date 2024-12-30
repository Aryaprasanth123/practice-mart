package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_Utility;

public class Subcategory_Search {
	public WebDriver driver;

	public Subcategory_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "un")
	WebElement category;
	@FindBy(name = "ut")
	WebElement subcategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement clickonsearch;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement table;

	public Subcategory_Search verifyuserisabletoselectcategoryfield() {
		category.click();
		Page_Utility page = new Page_Utility();
		page.selectByIndex(category, 2);
		return this;
	}

	public Subcategory_Search verifyuserisabletoentersubcategory(String subcategoryfield) {
		subcategory.sendKeys(subcategoryfield);
		return this;
	}

	public Subcategory_Search verifyTheUserIsAbleToSearchDetails() {
		clickonsearch.click();
		return this;
	}

	public boolean isTableDisplayed() {
		return table.isDisplayed();
	}
}
