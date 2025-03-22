package mobile;

import io.cucumber.java.en.Given;
import org.example.Utilities;
import org.openqa.selenium.By;

public class stepfile extends Utilities {

    @Given("enter charging")
    public void launchtheapp(){
       driver.findElement(By.xpath("")).click();
    }
}
