package screenshots;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generator.NameGenerator;


public class downpage {
	
    @Test
	public void take() throws IOException {
		
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	WebDriver driver  = new ChromeDriver();	

    	driver.get("http://automationpractice.com/index.php");
    	driver.manage().window().maximize();
    	
    	WebElement myWebElement = driver.findElement(By.id("facebook_block"));
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", myWebElement);
    	
       
      	TakesScreenshot screenshot =((TakesScreenshot)driver);
    	File file = screenshot.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(file, new File("prints//"+NameGenerator.generate()+".png"));
    	
       
       
}
    

}
