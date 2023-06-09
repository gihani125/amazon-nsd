package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class amz1_amazonsuggestedlist {

    @Test
    public void amazonsuggestedlist() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

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
        Thread.sleep(500);

        //select a suggested option
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div/div[1]/div[1]/div")).click();
        Thread.sleep(500);
    }
}