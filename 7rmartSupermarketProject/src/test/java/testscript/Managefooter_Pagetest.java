package testscript;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import constants.Constant;

import pages.Homepage;

import pages.Loginpage;

import pages.ManageFooter_Page;

import utilities.Excel_Utility;

public class Managefooter_Pagetest extends Base {
	public Homepage homepage;
	public ManageFooter_Page text;

	@Test
	public void verifyTheUserIsAbleToManageFooterText() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		text = homepage.userIsAbleToClickManageFooterText();
		text.userIsAbleToClickUpdateicon();
		String address = Excel_Utility.readStringData(1, 0, "ManageFooter_Text");
		text.userIsAbleToAddAddress(address);
		String email = Excel_Utility.readStringData(1, 1, "ManageFooter_Text");
		text.userIsAbleToAddEmail(email);
		String phone = Excel_Utility.readIntegerData(1, 2, "ManageFooter_Text");
		text.userIsAbleToAddPhoneNumber(phone);
		text.userIsAbleToclickupdate();
		boolean IsFooterTextCanUpdateSuccessfully = text.isFooterTextUpdateSuccessfully();
		assertTrue(IsFooterTextCanUpdateSuccessfully, Constant.ERRORMESSAGEFORMANAGEFOOTERTEXTPAGE);

	}
}
