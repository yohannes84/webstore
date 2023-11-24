package com.example.pms.selenium.customer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderPage {

    protected WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "street")
    private WebElement street;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "zip")
    private WebElement zip;
    @FindBy(id = "submitCustomer")
    private WebElement submitButton;

    @FindBy(id = "cardNumber")
    private WebElement cardNumber;
    @FindBy(id = "cardType")
    private WebElement cardType;
    @FindBy(id = "expirationDate")
    private WebElement expirationDate;
    @FindBy(id = "cvc")
    private WebElement cvc;
    @FindBy(id = "submitPayment")
    private WebElement submitPayment;

    public void checkData(String name, String email, String phone, String street, String city, String zip,
                          String cardNumber, String cardType, String expirationDate, String cvc) {
        assertThat(this.name.getText(),is(name));
        assertThat(this.email.getText(),is(email));
        assertThat(this.phone.getText(),is(phone));
        assertThat(this.street.getText(),is("Street: "+street));
        assertThat(this.city.getText(),is(city));
        assertThat(this.zip.getText(),is(zip));
        assertThat(this.cardNumber.getText(),is(cardNumber));
        assertThat(this.cardType.getText(),is(cardType));
        assertThat(this.expirationDate.getText(),is(expirationDate));
        assertThat(this.cvc.getText(),is(cvc));
    }

}
