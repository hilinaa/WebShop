package com.WAA.WebShop.domain;

import java.util.Date;

public class PaymentInformation {
    private String creditCardType;
    private int CardNumber;
    private Date validDate;
    private int validationCode;

    public PaymentInformation(String creditCardType, int cardNumber, Date validDate, int validationCode) {
        this.creditCardType = creditCardType;
        CardNumber = cardNumber;
        this.validDate = validDate;
        this.validationCode = validationCode;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
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
