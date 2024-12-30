package testscript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import constants.Constant;

import pages.Category_Add;
import pages.Category_Search;

import pages.Homepage;

import pages.Loginpage;

import utilities.Excel_Utility;

public class Category_Searchtest extends Base {
	public Homepage homepage;
	public Category_Add add;
	public Category_Search search;

	@Test
	public void verifyTheUserIsAbleToDisplayTheSearchedCategory() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		add = homepage.userisabletoclikcategorybutton();
		search = add.userisabletoclicksearch();
		String categoryname = Excel_Utility.readStringData(3, 0, "Add_Category");
		search.userisableTosearchwithCategoryName(categoryname);
		search.userisableTosearchTheCategory();
		boolean isTableIsDisplayed = search.isTableisdisplayed();
		assertTrue(isTableIsDisplayed, Constant.ERRORMESSAGEFORSEARCHCATEGORY);
	}
}
