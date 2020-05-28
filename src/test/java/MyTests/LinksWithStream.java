package MyTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksWithStream {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		//List<WebElement> footerList = driver.findElements(By.cssSelector("ul.footer-nav li"));
		
		List<String> newFooterList = new ArrayList<String>();
		driver.findElements(By.cssSelector("ul.footer-nav li"))
		.stream()
		.forEach(ele -> newFooterList.add(ele.getText()));
		
//		footerList.stream().forEach(ele -> newFooterList.add(ele.getText()));
		
		newFooterList.forEach(System.out::println);

	}

}
