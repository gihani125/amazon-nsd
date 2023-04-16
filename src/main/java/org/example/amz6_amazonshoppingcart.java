package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class amz6_amazonshoppingcart {

    @Test
    public void amazonShoppingCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
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
        Thread.sleep(2000);

        //select the 1st search option
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
        Thread.sleep(1500);

        // Click on Add to cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        Thread.sleep(2000);

        //Click on cart
        driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
        Thread.sleep(1000);

        //Select a value from the qty dropdown
        Select qtyDropdown = new Select(driver.findElement(By.id("quantity")));
        qtyDropdown.selectByValue("3");
        Thread.sleep(1000);

        //Click on save for later
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[3]/span/input")).click();
        Thread.sleep(500);

        // This  will scroll down the page
        js.executeScript("window.scrollBy(0,440)");
        Thread.sleep(500);

        //CLick on move to cart
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[3]/div/form/div[2]/div/div[4]/div/div[2]/div[1]/div/span/span/span/input")).click();
        Thread.sleep(500);

        // This  will scroll up the page
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(1000);

        // delete the selected item
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
        Thread.sleep(500);
    }
}