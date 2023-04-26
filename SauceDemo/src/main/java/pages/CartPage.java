package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import base.Base;

public class CartPage extends Base
{
    By prodnames=By.xpath("//div[@class='inventory_item_name']");
    
	public List<String> getProductsinCart()
	{
		List<String> second=driver.findElements(prodnames).stream().map(w->w.getText()).collect(Collectors.toList());
		return second;
	}
}
