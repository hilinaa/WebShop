package com.WAA.WebShop.domain;

import java.util.Date;

public class PaymentInformation {
    private String creditCardType;
    private int cardNumber;
    private Date validDate;
    private int validationCode;

    public PaymentInformation(String creditCardType, int cardNumber, int validationCode) {
        this.creditCardType = creditCardType;
        this.cardNumber = cardNumber;
//        this.validDate = validDate;
        this.validationCode = validationCode;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
       this.cardNumber = cardNumber;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public int getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(int validationCode) {
        this.validationCode = validationCode;
    }
}
