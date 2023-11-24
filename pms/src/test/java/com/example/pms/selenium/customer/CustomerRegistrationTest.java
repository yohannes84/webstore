package com.example.pms.selenium.customer;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomerRegistrationTest {

    private static PersonalInfoPage personalInfoPage;
    private PaymentInfoPage paymentInfoPage;
    private OrderPage orderPage;
    private static WebDriver driver;

    @BeforeClass
    public static void openTheBrowser() {
        // set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Diaby\\Desktop\\WAA\\Week2\\Lesson13\\webDriversDowloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Diaby\\Desktop\\WAA\\Week2\\Lesson13\\webDriversDowloads\\chrome-headless-shell-win64\\chrome-headless-shell.exe");
        options.addArguments("--remote-allow-origins=*");
        // create chrome instance
        driver = new ChromeDriver(options);
        personalInfoPage = new PersonalInfoPage(driver);
    }

    @AfterClass
    public static void closeTheBrowser() {
        driver.close();
    }

    @Test
    public void testCustomer() {
        personalInfoPage.open();
        personalInfoPage.enterData("Jon Doe", "jdoe@gmail.com", "64123456", "54 St",
                "Fairfield", "52556");
        paymentInfoPage= personalInfoPage.clickNext();
        paymentInfoPage.enterData("1234567890123456", "Visa", "11/26", "123");
        orderPage= paymentInfoPage.clickNext();
        orderPage.checkData("Jon Doe", "jdoe@gmail.com", "64123456","54 St", "Fairfield",
                "52556", "1234567890123456","Visa", "11/26",
                "123");
    }

}

