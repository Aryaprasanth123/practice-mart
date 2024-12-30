package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Adminuser_Search {
	public WebDriver driver;

	public Adminuser_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement username;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement userType;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchbynameandtype;
	@FindBy(xpath = "//div[@class='row-sm-12']")
	WebElement table;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement notfound;

	public Adminuser_Search userisabletoenterusername(String usernamefield) {
		username.sendKeys(usernamefield);
		return this;
	}

	public Adminuser_Search userisabletoselectusertype() {
		userType.click();
		Select dropdn1 = new Select(userType);
		dropdn1.selectByIndex(2);
		return this;
	}

	public Adminuser_Search userisabletosearchdetails() {
		searchbynameandtype.click();
		return this;
	}

	public boolean searchforparticularusernameintable() {

		return table.isDisplayed();

	}

	public boolean searchnotFound() {
		return notfound.isDisplayed();
	}

}
