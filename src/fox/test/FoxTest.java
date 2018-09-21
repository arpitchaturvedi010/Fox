package fox.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FoxTest {
	 private static WebDriver driver;
	

	 public void setUp() throws Exception 
	    {
	        System.setProperty("webdriver.chrome.driver", "E:\\sujithwp\\qa-automation-selenium-java-someswar\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    public void tearDown() throws Exception {
	        driver.quit();
	    }
	    
	    public void testFox() throws InterruptedException, AWTException, FileNotFoundException, IOException {
	    	 driver.get("https://www.fox.com/");
		     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		     Thread.sleep(4000);
		     //click on show 
		     WebElement show = driver.findElement(By.xpath("//a[contains(., 'Show')]"));
		     show.click();
		     Thread.sleep(4000);

		     // scroll down and capture last 4 shows 		     
		     //store names to list
		     Robot robot = new Robot();
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		     Thread.sleep(6000);
		        
			
		     List<WebElement> list=driver.findElements(By.xpath(" //div[@class='TileGrid_grid_vrnLT']//div/descendant::a[@class='Tile_title_2XOxg Tile_title_1kRJG']"));
		        System.out.println("total number of suggesions"+"     "+list.size());
		     int count= list.size();
		     int i;
		        for(i=(count-4);i<count;i++) {
		        	System.out.println(list.get(i).getText());
		            Support.writeData(list.get(i).getText());
	        	
		        }
		     
		     
		     
	    }
	    
	    
	    
}
