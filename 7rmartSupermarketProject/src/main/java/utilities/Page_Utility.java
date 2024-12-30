package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utility {
	public WebDriver driver;

	public void selectByIndex(WebElement dropdown, int index) {
		Select dropdn = new Select(dropdown);
		dropdn.selectByIndex(index);
	}

	public void darganddrop(WebElement drag, WebElement destination) {
		Actions action = new Actions(driver);
		action.moveToElement(drag);
		action.doubleClick(drag).perform();
		action.dragAndDrop(drag, destination).build().perform();

	}

	public void Selection(WebElement details) {
		Actions actions = new Actions(driver);
		actions.doubleClick().clickAndHold(details);
	}

	public void selectByText(WebElement dropdown, String text) {
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("admin");
	}
}
