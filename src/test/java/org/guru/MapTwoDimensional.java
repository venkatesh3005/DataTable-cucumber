package org.guru;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapTwoDimensional {
	static WebDriver driver;
@Given("user navigate guru page and clicks add customer")
public void user_navigate_guru_page_and_clicks_add_customer() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Greens-12\\eclipse-workspace\\CucuFeature\\driver\\chromedriver.exe" );
	   driver=new ChromeDriver();
	   driver.get("http://demo.guru99.com/telecom/index.html");
	   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
}

@When("user fill required fields and clicks submit button")
public void user_fill_required_fields_and_clicks_submit_button(io.cucumber.datatable.DataTable dataTable) throws Exception {
	List<Map<String,String>>l=dataTable.asMaps(String.class,String.class);
    driver.findElement(By.xpath("//label[@for='done']")).click();
    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(l.get(0).get("fname"));
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(l.get(1).get("lname"));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(l.get(1).get("email"));
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(l.get(0).get("address"));
    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(l.get(1).get("mobno"));
    JavascriptExecutor jc=(JavascriptExecutor)driver;
    WebElement f = driver.findElement(By.xpath("//input[@value='Submit']"));
    jc.executeScript("arguments[0].click()", f);
   
}

@Then("check whether customer id is generated")
public void check_whether_customer_id_is_generated() {
	String c = driver.getCurrentUrl();
	if(c.contains("uid")) {
		System.out.println("id created");
	}
	else {
		System.out.println("id not created");
	}
}


}
