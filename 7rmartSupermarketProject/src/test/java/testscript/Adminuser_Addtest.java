package testscript;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.io.IOException;

import constants.Constant;

import pages.Adminuser_Add;
import pages.Homepage;
import pages.Loginpage;
import utilities.Excel_Utility;

public class Adminuser_Addtest extends Base {
	public Homepage homepage;
	public Adminuser_Add adminuser;

	@Test
	public void userIsAbleToAddNewAdminwithvaliddetails() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		adminuser.userisabletoclickcreateNew();
		String usrname = Excel_Utility.readStringData(1, 0, "Admin_Pageadd");
		String pasword = Excel_Utility.readStringData(1, 1, "Admin_Pageadd");
		adminuser.userisabletoenterUsername(usrname).userisabletoenterPassword(pasword).userisabletoselectUsertype()
				.userisabletoclickSave();
		boolean IsgreenAlertIsDisplayed = adminuser.greenAlertisdisplayed();
		assertTrue(IsgreenAlertIsDisplayed, Constant.ERRORMESSAGEFORADMINUSERTEST);

	}

	@Test
	public void userIsAbleToAddNewAdminWithduplicateDetails() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		adminuser.userisabletoclickcreateNew();
		String usrname = Excel_Utility.readStringData(1, 0, "Admin_Pageadd");
		String pasword = Excel_Utility.readStringData(1, 1, "Admin_Pageadd");
		adminuser.userisabletoenterUsername(usrname).userisabletoenterPassword(pasword).userisabletoselectUsertype()
				.userisabletoclickSave();
		boolean IsRedAlertIsDisplayed = adminuser.redAlertisdisplayed();
		assertTrue(IsRedAlertIsDisplayed, Constant.ERRORMESSAGEFORADDADMINUSERTEST);
	}
}
