package screenshots;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generator.NameGenerator;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class particular_element {
	
	@Test
	public void main() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	WebDriver driver  = new ChromeDriver();	

    	driver.get("http://automationpractice.com/index.php");
    	driver.manage().window().maximize();
	
	WebElement element = driver.findElement(By.xpath ("//img[@alt='Blouse']"));

	// Along with driver pass element also in takeScreenshot() method.

	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

	ImageIO.write(screenshot.getImage(), "png", new File("prints//"+NameGenerator.generate()+".png"));

}
}
