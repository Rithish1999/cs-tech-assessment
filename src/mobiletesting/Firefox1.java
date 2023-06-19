package mobiletesting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\CS Tech Test\\Driver\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		
		
		Dimension size = new   Dimension(360,640);
		driver.manage().window().setSize(size);

		
		driver.findElement(By.linkText("https://www.getcalley.com/404-page-not-found/")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;

		File src =ts.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':','-');
		System.out.println(timestamp);
		String name= "FireFoxwindows1-360-640"+timestamp;
		System.out.println(name);
		String path="./Screenshot2/"+name+".png";
		File parmentFile =  new File(path);
		FileUtils.copyFile(src, parmentFile);
		String Url = driver.getCurrentUrl();
		if(Url.equals("https://www.getcalley.com/404-page-not-found/")) {
			System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase Failed");
		}
		
		driver.close();
		
		


	}

}
