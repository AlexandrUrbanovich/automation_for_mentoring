package com.epam.mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_001 {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test_001() {
        driver.get("https://cloud.google.com/");

        WebElement products = driver.findElement(By.xpath("//*[@id=\"top_of_page\"]/div[1]/div[1]/header/div[1]/div/div/div[2]/nav/ul/li[4]/a"));
        products.click();

        WebElement allProducts = driver.findElement(By.xpath("//*[@id=\"top_of_page\"]/div[1]/div[1]/header/div[1]/div/div/div[2]/nav/ul/li[4]/div/div/div[4]/ul/li"));
        allProducts.click();

        WebElement seePrincing = driver.findElement(By.xpath("//*[@id=\"google-cloud-platform\"]/div[1]/section/div[3]/a[2]"));
        seePrincing.click();

        WebElement calculator = driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/nav/div/div/ul/li[3]/a"));
        calculator.click();

        WebElement numberOfInstance = driver.findElement(By.xpath("//*[@id=\"input_51\"]"));
        numberOfInstance.click();
        numberOfInstance.sendKeys("4");

        WebElement mahineType = driver.findElement(By.id("select_value_label_47"));
        mahineType.click();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public void down() {
        driver.quit();
    }
}
