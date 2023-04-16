package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class amz4_amazonproductdetails {

    @Test
    public void amazonProductDetails() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Laptop");
        Thread.sleep(1500);

        //Click on search icon
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        Thread.sleep(2500);

        //select the 1st search option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
        Thread.sleep(2000);

        // View other images
        driver.findElement(By.xpath("//*[@id=\"a-autoid-5\"]/span/input")).click();
        Thread.sleep(500);

        //Scroll down the page to view details (https://stackoverflow.com/questions/30942041/slow-scrolling-down-the-page-using-selenium)
        for (int i = 0; i < 800; i += 7) {
            js.executeScript("window.scrollTo(0, " + i + ")");
        }
        Thread.sleep(1000);

        // Find "qty" dropdown
        WebElement element = driver.findElement(By.id("a-autoid-0-announce"));

        //Scroll to view Qty
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);

        //Select a value from the qty dropdown
        //driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]")).click();

        //Select a value from the qty dropdown
        Select qtyDrop = new Select(driver.findElement(By.id("quantity")));
        qtyDrop.selectByValue("5");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"selectQuantity\"]/span/div/div")).click();
        Thread.sleep(1000);


    }
}