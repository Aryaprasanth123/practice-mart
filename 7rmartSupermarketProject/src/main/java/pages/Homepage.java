package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbtn;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutbtn;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginpagetitle;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement moreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/a")
	WebElement clickcategory;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[4]/div/a")
	WebElement subcategoryclick;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement clickmanaganews;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[10]/div/a")
	WebElement managefooterclick;

	public Homepage userisabletoclickadminbutton() {
		adminbtn.click();
		return this;

	}

	public Homepage userisabletoclicklogoutbutton() {
		logoutbtn.click();
		return this;

	}

	public Adminuser_Add userisabletoclickMoreInfo() {
		moreinfo.click();
		return new Adminuser_Add(driver);
	}

	public Category_Add userisabletoclikcategorybutton() {
		clickcategory.click();
		return new Category_Add(driver);
	}

	public Subcategory_Add userisabletoclicksubcategorybutton() {
		subcategoryclick.click();
		return new Subcategory_Add(driver);
	}

	public Managenews_Add userisabletoclickmanageNews() {
		clickmanaganews.click();
		return new Managenews_Add(driver);
	}

	public ManageFooter_Page userIsAbleToClickManageFooterText() {
		managefooterclick.click();
		return new ManageFooter_Page(driver);
	}
}
