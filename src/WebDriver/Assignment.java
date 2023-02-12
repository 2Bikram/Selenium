package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import Automation.Assignment;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	static WebDriver driver;
	
	public static void main (String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
//		driver.get("http://live.techpanda.org/");
//		System.out.println(driver.getTitle());
		//
		
		try {
			Assignment g=new Assignment().google();
			System.out.println(g);
		}catch(Exception e) {
			System.out.println("check qspaider");
		}
		try {
			Assignment y=new Assignment().yahoo();
			System.out.println(y);
		}catch(Exception e){
			System.out.println("check yahoo");
		}
		try {
			Assignment b=new Assignment().bing();
			System.out.println(b);
		}catch(Exception e){
			System.out.println("check bing");
		}
		driver.quit();
	}
	public Assignment google() throws InterruptedException {
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("maa");
		Thread.sleep(5000);
		List <WebElement> suggestions= driver.findElements(By.xpath("//div[@role='option']"));
		System.out.println(suggestions.size());
		for(int i=0;i<suggestions.size();i++) {
			if(suggestions.get(i).getText().equals("maa mangala photo")){
				suggestions.get(i).click();
				break;
			}
		}
		return null;
	}
	public Assignment yahoo() throws InterruptedException {
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("maa");
		Thread.sleep(5000);
		List <WebElement> suggestions= driver.findElements(By.xpath("//li[@class='sa-item prog-sugg']"));
		System.out.println(suggestions.size());
		for(int i=0;i<suggestions.size();i++) {
			if(suggestions.get(i).getText().equals("maa kali")){
				suggestions.get(i).click();
				break;
			}
		}
		return null;
	}
	public Assignment bing() throws InterruptedException {
		driver.get("https://www.bing.com/");
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("maa");
		Thread.sleep(1000);
		List <WebElement> suggestions= driver.findElements(By.xpath("//li[@role='option']"));
		System.out.println(suggestions.size());
		for(int i=0;i<suggestions.size();i++) {
			if(suggestions.get(i).getText().equals("maa kali")){
				suggestions.get(i).click();
				break;
			}
		}
		return null;
	}
}


