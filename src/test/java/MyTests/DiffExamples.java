package MyTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiffExamples {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://www.amazon.in/");
//		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		//1
		//linksList.forEach(ele -> System.out.println(ele.getText()));
		
		//2
//		List<String> collect = linksList.stream().filter(ele -> !ele.getText().equals("")).map(ele -> ele.getText()).
//				collect(Collectors.toList());
//		
//		collect.forEach(ele -> System.out.println(ele));
		
		//3
//		String firstEle = linksList.stream().filter(ele -> !ele.getText().equals("")).findFirst().get().getText();
//		System.out.println(firstEle);
		
		//4
//		String text = linksList.stream().filter(ele -> !ele.getText().equals("")).findAny().get().getText();
//		System.out.println(text);
		
		//5
//		List<String> collect = 
//		linksList.stream()
//		.filter(ele -> !ele.getText().equals("") && ele.getText().startsWith("Amazon"))
//		.map(ele -> ele.getText())
//		.collect(Collectors.toList());
//		
//		collect.forEach(ele -> System.out.println(ele));
		
		//6
//		List<String> AllLinkText = linksList.stream()
//				.filter(ele -> !ele.getText().isEmpty())
//				.filter(ele -> !ele.getText().startsWith(" "))
//				.map(ele -> ele.getText().trim())
//				.collect(Collectors.toList());	
//		AllLinkText.forEach(ele -> System.out.println(ele));

		//linksList.stream().anyMatch(ele -> ele.getText().contains("Amazon"));
		
		
		
		//*************************
		//7
//		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
//		List<WebElement> checkList = driver.findElements(By.cssSelector("td.select-checkbox"));
//		checkList.stream().forEach(ele -> ele.click());
		
		//8
//		driver.get("https://www.freshworks.com/");
//		List<String> footerList = new ArrayList<String>();
//		driver.findElements(By.cssSelector("ul.footer-nav li")).stream()
//										.forEach(ele -> footerList.add(ele.getText()));
//		footerList.forEach(System.out::println);
		

		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.findElement(By.linkText("Good PopUp #3")).click();

//		String text = driver.getWindowHandles()
//								.stream()
//								.map(handler -> driver.switchTo().window(handler).getTitle())
//								.filter(title.contains("PopupTest"))
//								.map(ele -> ele)
//								.orElseThrow(() -> {
//													throw new RuntimeException("No Such window Found");
//													}
//								);
		
		String text = switchToWindow(driver, "PopupTest Thursday");
		System.out.println(text);
		
		
		driver.quit();
		
		
		
	}
	
	public static String switchToWindow (WebDriver driver, String title) {
       return driver.getWindowHandles()
                .stream()
                .map(windowHandle -> driver.switchTo().window(windowHandle).getTitle())
                .filter(ele -> ele.contains(title))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No Such Window Exists!");
                });
}

}
