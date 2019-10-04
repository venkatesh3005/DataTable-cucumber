package org.guru;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapOneDimensional {
	static WebDriver driver;
	@Given("user navigates guru page and clicks add customer")
	public void user_navigates_guru_page_and_clicks_add_customer() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Greens-12\\eclipse-workspace\\CucuFeature\\driver\\chromedriver.exe" );
		   driver=new ChromeDriver();
		   driver.get("http://demo.guru99.com/telecom/index.html");
		   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("user fill all fields and clicks submit button")
	public void user_fill_all_fields_and_clicks_submit_button(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String>l=dataTable.asMap(String.class,String.class);
	    driver.findElement(By.xpath("//label[@for='done']")).click();
	    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(l.get("fname"));
	    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(l.get("lname"));
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(l.get("email"));
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(l.get("address"));
	    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(l.get("mobno"));
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	@Then("validate whether customer id is generated")
	public void validate_whether_customer_id_is_generated() {
		String c = driver.getCurrentUrl();
		if(c.contains("uid")) {
			System.out.println("id created");
		}
		else {
			System.out.println("id not created");
		}
	  
	}



}
