package pages;

import org.openqa.selenium.By;

import base.Base;

public class LoginPage extends Base
{
	By uid=By.id("user-name");
	By pwd=By.id("password");
	By loginbtn=By.id("login-button");
	By errormsg=By.xpath("//h3[@data-test='error']");

	public void login(String username,String password)
	{
		driver.findElement(uid).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginbtn).click();
		try{Thread.sleep(2000);}catch(Exception e) {}
	}	
	public String getErrorMessage()
	{
		if(driver.findElements(errormsg).size()>0)
		{
		   return driver.findElement(errormsg).getText();
		}
		else
		{
			return "No error message";
		}
	}
	
}
