package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class particularElement {
	
	@Test
	public void print() throws IOException, InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://automationpractice.com");
	driver.manage().window().maximize();

	WebElement element = driver.findElement(By.xpath ("//img[@alt='Blouse']"));

	// Along with driver pass element also in takeScreenshot() method.

	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

	ImageIO.write(screenshot.getImage(), "jpg", new File("test.jpg"));
	
	
	
//    WebElement myWebElementL = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-toggle='tab']")));
//    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", myWebElementL);
//    
//    WebElement myWebElement = driver.findElement(By.xpath("//img[@alt='Blouse']"));
//  
//    //Get entire page screenshot
//    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    BufferedImage  fullImg = ImageIO.read(screenshot);
//
//    //Get the location of element on the page
//     Point point = myWebElement.getLocation();
//
//    //Get width and height of the element
//    int eleWidth = myWebElement.getSize().getWidth();
//     int eleHeight = myWebElement.getSize().getHeight();
//
//     System.out.println(point.getX()+" "+point.getY()+" "+eleWidth+" "+eleHeight);
//     
//     //Crop the entire page screenshot to get only element screenshot
//      BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
//      eleWidth, eleHeight);
//      ImageIO.write(eleScreenshot, "png", screenshot);
//
//	//Copy the element screenshot to disk
//	File screenshotLocation = new File("poi.png");
//	FileUtils.copyFile(screenshot, screenshotLocation);

    
    driver.quit();
	
	
  }

    
}

