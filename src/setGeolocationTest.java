import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;

public class setGeolocationTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools= driver.getDevTools();
		devTools.createSession();
		Map<String,Object> coordinates=new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
//		devTools.send(Emulation.setGeolocationOverride(Optional.of(40), Optional.of(3), Optional.of(1)));
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title=driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
		System.out.println(title);

	}

}
