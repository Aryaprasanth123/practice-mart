package testscript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import constants.Constant;

import pages.Category_Add;

import pages.Homepage;

import pages.Loginpage;

import utilities.Excel_Utility;

public class Category_Addtest extends Base {
	public Homepage homepage;
	public Category_Add add;

	@Test
	public void toEnterCategory() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		add = homepage.userisabletoclikcategorybutton();
		add.userisabletoclicknewbutton();
		String categoryname = Excel_Utility.readStringData(2, 0, "Add_Category");
		add.userisabletoentercategoryname(categoryname).userisabletoclickdiscount().userisabletouploadfile()
				.userisabletoselecttopmenu().userisabletoselectleftmenu().userisabletocliksave();
		boolean alertt = add.isalertisDisplayed();
		assertTrue(alertt, Constant.ERRORMESSAGEFORNEWCATEGORY);

	}
}
