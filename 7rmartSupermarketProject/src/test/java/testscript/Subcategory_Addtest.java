package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Homepage;
import pages.Loginpage;
import pages.Subcategory_Add;
import utilities.Excel_Utility;

public class Subcategory_Addtest extends Base {
	public Homepage homepage;
	public Subcategory_Add addsubcategory;

	@Test
	public void toAddSubCategory() throws IOException {
		String username = Excel_Utility.readStringData(1, 0, "Login_Page");
		String password = Excel_Utility.readStringData(1, 1, "Login_Page");
		Loginpage login = new Loginpage(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		addsubcategory = homepage.userisabletoclicksubcategorybutton();
		addsubcategory.userisabletoclicknewbutton().userisabletoselectcategoryfield();
		String subcategoryname = Excel_Utility.readStringData(2, 0, "Add_SubCategory");
		addsubcategory.userisabletoentersubcategory(subcategoryname).userisabletouploadimage()
				.userisabletoclicksavebutton();
		boolean IsAlertIsDispalyed = addsubcategory.isalertDisplayed();
		assertTrue(IsAlertIsDispalyed, Constant.ERRORMESSAGEFORADDSUBCATEGORY);
	}
}
