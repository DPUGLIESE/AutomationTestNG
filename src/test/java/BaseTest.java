/**
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.String;  
import java.util.concurrent.TimeUnit;

import org.testng.Assert;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;
/**
 * @author Daniel Pugliese - devspark
 *
 */
public abstract class BaseTest {
	
private WebDriver driver;
private static final String BASEURL = "http://www.google.com";

@BeforeClass
public void setUp(){
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(BASEURL);
}

@AfterClass  
public void tearDown() throws Exception {  
    driver.close();  
} 
public void elementExist(String element) {
	Assert.assertTrue(
			driver.findElements(By.id(element)).size() > 0 ||
			driver.findElements(By.className(element)).size() > 0 ||
			driver.findElements(By.cssSelector(element)).size() > 0 ||
			driver.findElements(By.tagName(element)).size() > 0 ||
			driver.findElements(By.xpath(element)).size() > 0
			);
	
}
public void elementExistsById(String element){
	Assert.assertNotNull(driver.findElement(By.id(element)));
}

public void elementExistsByClass(String element){
	Assert.assertNotNull(driver.findElement(By.className(element)));
}

public void elementExistsBySelector(String element){
	Assert.assertNotNull(driver.findElement(By.cssSelector(element)));
}

public void elementExistsByName(String element){
	Assert.assertNotNull(driver.findElement(By.tagName(element)));
}

public void elementExistsByPath(String element){
	Assert.assertNotNull(driver.findElement(By.xpath(element)));
}

public String getCurrentURL(){
	return driver.getCurrentUrl();
}

public void goToPage(String page){
	driver.get(BASEURL + page + ".html");
}


public void clickElementById(String element){
	driver.findElement(By.id(element)).click();

}
public void clickElementByPath(String element){
	driver.findElement(By.xpath(element)).click();

}
public void clickElementBySelector(String element){
	driver.findElement(By.cssSelector(element)).click();

}
public void clickElementByClass(String element){
	driver.findElement(By.className(element)).click();

}
public void clickElementByName(String element){
	driver.findElement(By.tagName(element)).click();

}
public void typeText(String element, String text){
	driver.findElement(By.id(element)).sendKeys(text);
}
}