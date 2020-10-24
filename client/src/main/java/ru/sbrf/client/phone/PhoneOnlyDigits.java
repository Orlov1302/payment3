package ru.sbrf.client.phone;

public class PhoneOnlyDigits extends Phone {
    public PhoneOnlyDigits(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String getMaskNumberPhone() {
        return "9999999999";
    }
}

//