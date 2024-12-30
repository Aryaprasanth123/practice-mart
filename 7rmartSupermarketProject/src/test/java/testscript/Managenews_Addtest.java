package testscript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import constants.Constant;

import pages.Homepage;

import pages.Loginpage;

import pages.Managenews_Add;

import utilities.Excel_Utility;

public class Managenews_Addtest extends Base {
	public Homepage homepage;
	public Managenews_Add news;

	@Test
	public void toManageNews() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		news = homepage.userisabletoclickmanageNews();
		news.userisabletoclicknewbutton();
		String newsfield = Excel_Utility.readStringData(3, 0, "Manage_News");
		news.userisabletoenterNewsinnewsfield(newsfield).userisabletoclicksavebutton();
		boolean IsalertAlertIsDisplayed = news.isalertdisplayed();
		assertTrue(IsalertAlertIsDisplayed, Constant.ERRORMESSAGEFORMANAGENEWS);

	}
}
