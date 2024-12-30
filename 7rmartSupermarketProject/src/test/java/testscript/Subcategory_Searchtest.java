package testscript;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import constants.Constant;

import pages.Homepage;

import pages.Loginpage;

import pages.Subcategory_Add;
import pages.Subcategory_Search;

import utilities.Excel_Utility;

public class Subcategory_Searchtest extends Base {
	public Homepage homepage;
	public Subcategory_Add addsubcategory;
	public Subcategory_Search subcategory;

	@Test
	public void verifyUserIsAbleToSearchWithSubCategoryName() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		addsubcategory = homepage.userisabletoclicksubcategorybutton();
		subcategory = addsubcategory.userisabletoclicksearchbutton();
		subcategory.verifyuserisabletoselectcategoryfield();
		String subcategoryname = Excel_Utility.readStringData(3, 0, "Add_SubCategory");
		subcategory.verifyuserisabletoentersubcategory(subcategoryname);
		subcategory.verifyTheUserIsAbleToSearchDetails();
		boolean isTableIsDisplayed = subcategory.isTableDisplayed();
		assertTrue(isTableIsDisplayed, Constant.ERRORMESSAGEFORSEARCHSUBCATEGORY);
	}
}
