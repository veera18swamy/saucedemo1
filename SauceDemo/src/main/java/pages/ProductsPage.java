package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class ProductsPage extends Base
{

	By products=By.xpath("//span[text()='Products']");
	By menu=By.cssSelector("#react-burger-menu-btn");
	By logout=By.linkText("Logout");
	
	public boolean checkProductheading()
	{
		List<WebElement> pr= driver.findElements(products);
		if(pr.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void signout()
	{
		driver.findElement(menu).click();
		try{Thread.sleep(1000);}catch(Exception e) {}
		driver.findElement(logout).click();
	}
	public List<String> addProducts()
	{
		int n;
		String str;
		List<String> first=new ArrayList<String>();
		for(int i=1;i<=2;i++)
		{
			n=new Random().nextInt(6-1)+1;
			str=driver.findElement(By.xpath("(//button[text()='Add to cart'])["+n+"]/ancestor::div[2]/div[1]/a")).getText();
			first.add(str);
			try{Thread.sleep(2000);}catch(Exception e) {}
			driver.findElement(By.xpath("(//button[text()='Add to cart'])["+n+"]")).click();
		}
		return first;
	}
	
	public void gotoCart()
	{
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		try{Thread.sleep(1000);}catch(Exception e) {}
	}
}
