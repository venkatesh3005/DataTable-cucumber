package org.guru;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GuruDemo {
static WebDriver driver;
@Given("user is in guru page and clicks add customer")
public void user_is_in_guru_page_and_clicks_add_customer() {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Greens-12\\eclipse-workspace\\CucuFeature\\driver\\chromedriver.exe" );
	   driver=new ChromeDriver();
	   driver.get("http://demo.guru99.com/telecom/index.html");
	   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
    
    
}

@When("user fills all the fields and clicks submit button")
public void user_fills_all_the_fields_and_clicks_submit_button(io.cucumber.datatable.DataTable dataTable) {
    
    List<String>l=dataTable.asList(String.class);
    driver.findElement(By.xpath("//label[@for='done']")).click();
    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(l.get(0));
    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(l.get(1));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(l.get(2));
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(l.get(3));
    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(l.get(4));
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
}

@Then("validate customer id is generated or not")
public void validate_customer_id_is_generated_or_not() {
	String c = driver.getCurrentUrl();
	if(c.contains("uid")) {
		System.out.println("id created");
	}
	else {
		System.out.println("id not created");
	}
  
    
}



}
