package testscript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constant;

import pages.Loginpage;

import utilities.Excel_Utility;
import utilities.Faker_Utility;

public class Loginpage_Test extends Base {
	@Test
	@Parameters({ "username", "password" })
	public void verifytheUserIsAbleToLoginWithValidCredentials(String usrnam, String pasword) {
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(usrnam, pasword);
		login.click_Signin();
		boolean IsHomePageIsDisplayed = login.isDashBoardLoaded();
		assertTrue(IsHomePageIsDisplayed, Constant.ERRORMESSAGEFORLOGIN);

	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "arya", "vaidu" } };
		return data;
	}

	@Test(dataProvider = "credentials")
	public void verifytheUserisAbleToLoginWithInvalidCredentials(String usernm, String paswrd) {
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(usernm, paswrd);
		login.click_Signin();
		boolean IsHomePageIsDisplayed = login.isDashBoardLoaded();
		assertTrue(IsHomePageIsDisplayed, Constant.ERRORMESSAGEFORINVALIDLOGIN);

	}

	@Test(groups = { "smoke" })

	public void verifyTheuserisAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = Excel_Utility.readStringData(2, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		login.click_Signin();
		boolean IsalertIsDisplayed = login.alert();
		assertTrue(IsalertIsDisplayed, Constant.ERRORMESSAGEFORINVALIDUSERNAMEANDVALIDPASWRD);

	}

	@Test
	public void verifyTheUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		Faker_Utility fakerutility = new Faker_Utility();
		String username = fakerutility.getFakeFirstName();
		String password = fakerutility.getFakeLastName();
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		login.click_Signin();
		boolean IsalertIsDisplayed = login.alert();
		assertTrue(IsalertIsDisplayed, Constant.ERRORMESSAGEFORVALIDUSERANDINVALIDPASWRD);
	}
}
