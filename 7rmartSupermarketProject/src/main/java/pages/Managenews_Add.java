package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managenews_Add {
	public WebDriver driver;

	public Managenews_Add(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newclick;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement alert;

	public Managenews_Add userisabletoclicknewbutton() {
		newclick.click();
		return this;
	}

	public Managenews_Add userisabletoenterNewsinnewsfield(String newsfield) {
		news.sendKeys(newsfield);
		return this;
	}

	public Managenews_Add userisabletoclicksavebutton() {
		save.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alert.isDisplayed();
	}

}
