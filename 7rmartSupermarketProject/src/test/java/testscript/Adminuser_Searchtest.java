package testscript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import java.io.IOException;

import constants.Constant;

import pages.Adminuser_Add;
import pages.Adminuser_Search;

import pages.Homepage;

import pages.Loginpage;

import utilities.Excel_Utility;

public class Adminuser_Searchtest extends Base {
	public Homepage homepage;
	public Adminuser_Add adminuser;
	public Adminuser_Search search;

	@Test
	public void searchForParticularUserNameAndPassword() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		String uname = Excel_Utility.readStringData(3, 0, "Admin_search");
		search = adminuser.userisabletoclicksearchbutton();
		search.userisabletoenterusername(uname);
		search.userisabletoselectusertype();
		search.userisabletosearchdetails();
		boolean isTableIsDisplayed = search.searchforparticularusernameintable();
		assertTrue(isTableIsDisplayed, Constant.ERRORMESSAGEFORSEARCHADMIN);
	}

	@Test
	public void searchItemNotFound() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		String usname = Excel_Utility.readStringData(2, 0, "Admin_search");
		search = adminuser.userisabletoclicksearchbutton();
		search.userisabletoenterusername(usname);
		search.userisabletoselectusertype();
		search.userisabletosearchdetails();
		boolean itemNotFound = search.searchnotFound();
		assertTrue(itemNotFound, Constant.ERRORMESSAGEFORSEARCHADMINTEST);
	}
}
