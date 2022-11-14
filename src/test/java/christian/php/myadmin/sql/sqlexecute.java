package christian.php.myadmin.sql;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sqlexecute {

	
@Test
public void execute() throws InterruptedException, AWTException {

    ChromeOptions options = new ChromeOptions();



WebDriverManager.chromedriver().driverVersion("107.0.5304.6200").setup();
WebDriver driver=new ChromeDriver(options);

	String table = "students";
	driver.navigate().to("http://localhost/phpmyadmin/index.php?route=/table/sql&db=aebrainprod&table=students");
	driver.manage().window().maximize();
	String query1 = "SELECT * FROM `"+table+"` WHERE `StudentRegno` LIKE '12%'";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement clear = driver.findElement(By.cssSelector("#clear"));
	  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",clear);

	clear.click();
	Thread.sleep(5000);

	
	WebElement queryElement1 = driver.findElement(By.xpath("(//pre[@role='presentation'])[3]"));
	JavascriptExecutor j = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",queryElement1);

    j.executeScript("arguments[0].click();", queryElement1);
	Thread.sleep(5000);
	
	   Robot robot1 = new Robot();

	   Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	  StringSelection stringSelection = new StringSelection(query1);

	  clipboard.setContents(stringSelection, null);

	  robot1.keyPress(KeyEvent.VK_CONTROL);
	  robot1.keyPress(KeyEvent.VK_V);
	  robot1.keyRelease(KeyEvent.VK_V);
	  robot1.keyRelease(KeyEvent.VK_CONTROL);
	  
	  WebElement Go =  driver.findElement(By.xpath("//input[@value='Go']"));
		 JavascriptExecutor j2 = (JavascriptExecutor) driver;
		    j2.executeScript("arguments[0].click();", Go);
			  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",Go);

			Thread.sleep(5000);
			
			  WebElement tableElement = driver.findElement(By.xpath("(//*[contains(@class,'pre_wrap ')])[1]"));
			  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",tableElement);

			  String text2= tableElement.getText();
				Thread.sleep(5000);

	  WebElement togglequerybox = driver.findElement(By.id("togglequerybox"));
	  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",togglequerybox);

	  JavascriptExecutor j3 = (JavascriptExecutor) driver;
	    j3.executeScript("arguments[0].click();", togglequerybox);
		Thread.sleep(5000);
		
		
		driver.findElement(By.cssSelector("#clear")).click();
		  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",clear);

		Thread.sleep(5000);
		
	  String query2= "SELECT * FROM `"+table+"` WHERE `StudentRegno` = '"+text2+"'";
	  driver.findElement(By.cssSelector("#clear")).click();
		Thread.sleep(5000);	
			
		   Robot robot2 = new Robot();

		   Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();

		  StringSelection stringSelection2 = new StringSelection(query2);

		  clipboard2.setContents(stringSelection2, null);

		  robot2.keyPress(KeyEvent.VK_CONTROL);
		  robot2.keyPress(KeyEvent.VK_V);
		  robot2.keyRelease(KeyEvent.VK_V);
		  robot2.keyRelease(KeyEvent.VK_CONTROL);
		  
	  Thread.sleep(5000);
	  
		    j2.executeScript("arguments[0].click();", Go);
			  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",Go);

			Thread.sleep(5000);
	String status = driver.findElement(By.cssSelector(".alert-success")).getText();

	Assert.assertTrue(status.contains("Showing rows 0 - 0"));
	Thread.sleep(5000);
	
	  WebElement tableElement2 = driver.findElement(By.xpath("(//*[contains(@class,'pre_wrap ')])[1]"));
		 String text3= tableElement2.getText();
		  js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",tableElement2);
		Thread.sleep(5000);
		
		Assert.assertEquals(text2,text3,"Strings of table value are Not equal");

}


}
