package com.epam.mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test_001 {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test_001() throws InterruptedException {
        driver.get("https://cloud.google.com/");

        WebElement products = driver.findElement(By.xpath("//*[@id=\"top_of_page\"]/div[1]/div[1]/header/div[1]/div/div/div[2]/nav/ul/li[4]/a"));
        products.click();

        WebElement allProducts = driver.findElement(By.xpath("//*[@id=\"top_of_page\"]/div[1]/div[1]/header/div[1]/div/div/div[2]/nav/ul/li[4]/div/div/div[4]/ul/li"));
        allProducts.click();

        WebElement seePrincing = driver.findElement(By.xpath("//*[@id=\"google-cloud-platform\"]/div[1]/section/div[3]/a[2]"));
        seePrincing.click();

        WebElement calculator = driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/nav/div/div/ul/li[3]/a"));
        calculator.click();

        driver.switchTo().frame(driver.findElement(By.id("idIframe")));
        WebElement numberOfInstance = driver.findElement(By.xpath("//*[@id=\"input_51\"]"));
        numberOfInstance.sendKeys("4");

        WebElement mahineType = driver.findElement(By.id("select_value_label_47"));
        Thread.sleep(2000);
        mahineType.click();

        WebElement nOneStandart = driver.findElement(By.id("select_option_210"));
        nOneStandart.click();

        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[7]/div[1]/md-input-container/md-checkbox"));
        Thread.sleep(2000);
        checkBox.click();

        WebElement numberOfGPU = driver.findElement(By.id("select_value_label_333"));
        numberOfGPU.click();

        WebElement numOfGPU = driver.findElement(By.id("select_option_340"));
        numOfGPU.click();

        WebElement gpuType = driver.findElement(By.id("select_value_label_334"));
        Thread.sleep(2000);
        gpuType.click();

        WebElement gType = driver.findElement(By.id("select_option_345"));
        Thread.sleep(2000);
        gType.click();

        WebElement localSSD = driver.findElement(By.id("select_value_label_48"));
        localSSD.click();

        WebElement lSSD = driver.findElement(By.id("select_option_166"));
        Thread.sleep(2000);
        lSSD.click();

        WebElement dataCentrLocation = driver.findElement(By.id("select_value_label_49"));
        Thread.sleep(2000);
        dataCentrLocation.click();

        WebElement dCLocation = driver.findElement(By.id("select_option_180"));
        Thread.sleep(2000);
        dCLocation.click();

        WebElement communitedUsage = driver.findElement(By.id("select_value_label_50"));
        communitedUsage.click();

        WebElement cUsage = driver.findElement(By.id("select_option_81"));
        cUsage.click();

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[12]/button"));
        addButton.click();
    }

    @Test(dependsOnMethods = "test_001")
    public void test_002() {
        WebElement vmClass = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]"));
        assertTrue(vmClass.getText().contains("regular"));

        WebElement instance = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[3]"));
        assertTrue(instance.getText().contains("n1-standard-8"));

        WebElement region = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[4]"));
        assertTrue(region.getText().contains("Frankfurt"));

        WebElement localSSD = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[5]"));
        assertTrue(localSSD.getText().contains("2x375 GB"));

        WebElement commitment = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[6]"));
        assertTrue(commitment.getText().contains("1 Year"));

        WebElement estimateInMonth = driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b"));
        System.out.println(estimateInMonth.getText());
        assertTrue(estimateInMonth.getText().contains("USD 1,187.77"));
    }


    @AfterClass
    public void down() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
