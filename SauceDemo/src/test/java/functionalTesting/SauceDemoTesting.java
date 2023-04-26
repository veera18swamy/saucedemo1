package functionalTesting;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Base;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class SauceDemoTesting extends Base
{
	LoginPage loginpage =new LoginPage();
	ProductsPage productspage=new ProductsPage();
	CartPage cartpage=new CartPage();

	@Test(priority=1)
	public void verifyValidLogin()
	{
		loginpage.openUrl("http://www.saucedemo.com");
		loginpage.login("standard_user", "secret_sauce");
		boolean status=productspage.checkProductheading();
		test=report.createTest("Validate for Valid Login");
		if(status==true)
		{
			test.log(Status.PASS, "Login is Passed for Valid Login");
			takeScreenshot("LoginPage.png");
			productspage.signout();
		}
		else
		{
			test.log(Status.FAIL, "Login is Failed for Valid Login");
			takeScreenshot("LoginPage.png");
		}
	}
	@Test(priority=2)
	public void verifyInvalidLogin()
	{
		loginpage.openUrl("http://www.saucedemo.com");
		loginpage.login("standard_user", "dksflsd");
		String errormessage=loginpage.getErrorMessage();
		test=report.createTest("Validate for InValid Login");
		if(errormessage.contains("password do not match any user"))
		{
			test.log(Status.PASS, "Error is displayed for invalid Login");
			takeScreenshot("inLoginPage.png");
		}
		else
		{
			test.log(Status.FAIL, "No proper error message for invalid login");
			takeScreenshot("inLoginPage.png");
		}
	}
	@Test(priority=3)
	public void veirfyProductsinCart()
	{
		loginpage.openUrl("http://www.saucedemo.com");
		loginpage.login("standard_user", "secret_sauce");
		List<String> first=productspage.addProducts();
		productspage.gotoCart();
		List<String> second= cartpage.getProductsinCart();
		test=report.createTest("verify products in Cart");
		if(first.equals(second))
		{
			test.log(Status.PASS, "Products in cart are same");
			takeScreenshot("CartPage.png");
		}
		else
		{
			test.log(Status.FAIL, "Products in cart are not  same");
			takeScreenshot("CartPage.png");
		}
		
		
	}
}
