package testscript;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.IOException;

import constants.Constant;

import pages.Loginpage;

import utilities.Excel_Utility;

import pages.Homepage;

public class Homepage_Test extends Base {
	public Homepage homepage;

	@Test(retryAnalyzer = retry.Retry.class)
	public void isTheUserIsAbleToLogOut() throws IOException {

		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		homepage.userisabletoclickadminbutton();
		homepage.userisabletoclicklogoutbutton();
		String expectedResult = "Login | 7rmart supermarket";
		String actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult, Constant.ERRORMESSAGEFORHOMEPAGE);
	}
}
