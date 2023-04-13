package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class amz5_amazonaddtocartfunction {
    String itemName;
    String itemPrice;

    @Test
    public void amazonProductDetails() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\gihan\\IdeaProjects\\Amazon_Automation\\drivers\\chromedriver.exe");
        ChromeOptions options = new  ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Navigate to Amazon website
        driver.navigate().to("https://www.amazon.com/");
            Thread.sleep(1000);


            //Close address changing popup
            driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
            Thread.sleep(500);

            //Click on "All" dropdown to show values
            driver.findElement(By.xpath("//*[@id=\"nav-search-bar-form\"]/div[1]")).click();
            Thread.sleep(1000);

            //Select a value from the ALL dropdown
            WebElement allDropdownValue = driver.findElement(By.id("searchDropdownBox"));
            Select dropdown = new Select(allDropdownValue);
            dropdown.selectByVisibleText("Electronics");
            Thread.sleep(1000);

            //Type "Laptop" in search bar
            driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("jumper Laptop 16 Inch FHD IPS Display (16:10)");
            Thread.sleep(1500);

            //Click on search icon
            driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
            Thread.sleep(2500);

            //select the 1st search option
            driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
            Thread.sleep(2000);

            //Select a value from the qty dropdown
            Select qtyDrop = new Select(driver.findElement(By.id("quantity")));
            qtyDrop.selectByValue("5");
            Thread.sleep(500);

            driver.findElement(By.xpath("//*[@id=\"selectQuantity\"]/span/div/div")).click();
            Thread.sleep(1000);

            // Click on Add to cart
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
            Thread.sleep(1000);

    }
}