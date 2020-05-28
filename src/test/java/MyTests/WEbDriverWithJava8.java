package MyTests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WEbDriverWithJava8 {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println(linksList.size());
		
//		for (WebElement element : linksList) {
//			System.out.println(element.getText());
//		}
		
		//1. 
		//linksList.forEach(ele -> System.out.println(ele.getText()));

		//2.
		List<String> collectlList = linksList.
				stream().
					filter(ele -> !ele.getText().equals("")).
						map(ele -> ele.getText()).
							collect(Collectors.toList());
		
		collectlList.forEach(ele -> System.out.println(ele));
		
		//3. 
//		String firstText = linksList.stream().filter(ele -> !ele.getText().equals("")).findFirst().get().getText();
//		System.out.println(firstText);
		
		//4. 
//		String findAny = linksList.stream().filter(ele -> !ele.getText().equals("")).findAny().get().getText();
//		System.out.println(findAny);
		
		//5. exclude blank texts and which starts with or contains Amazon
//		List<String> collect = linksList.stream()
//					.filter(ele -> !ele.getText().equals("") && ele.getText().contains("Amazon"))
//					.map(ele -> ele.getText())
//					.collect(Collectors.toList());
//		
//		collect.forEach(ele -> System.out.println(ele));
		
		//6. 
		List<String> AllLinkTextList = linksList.stream()
					.filter(ele -> !ele.getText().isEmpty())
					.filter(ele -> !ele.getText().startsWith(" "))
					.map(ele -> ele.getText().trim())
					.collect(Collectors.toList());
		AllLinkTextList.forEach(ele -> System.out.println(ele));
		
		
		
		
		
		
		driver.quit();
		
		
		
		
		
	}

}
