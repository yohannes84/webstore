package com.example.pms.selenium.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {

    protected WebDriver driver;

    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "cardNumber")
    private WebElement cardNumber;
    @FindBy(name = "cardType")
    private WebElement cardType;
    @FindBy(name = "expirationDate")
    private WebElement expirationDate;
    @FindBy(name = "cvc")
    private WebElement cvc;
    @FindBy(name = "submitPayment")
    private WebElement submitPayment;

    public OrderPage clickNext(){
        submitPayment.click();
        return new OrderPage(driver);
    }

    public void enterData(String cardNumber, String cardType, String expirationDate, String cvc ){
        this.cardNumber.sendKeys(cardNumber);
        this.cardType.sendKeys(cardType);
        this.expirationDate.sendKeys(expirationDate);
        this.cvc.sendKeys(cvc);
    }
}
