package ru.sbrf.client.phone;

public class PhonePlusAndDigits extends Phone {
    public PhonePlusAndDigits(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String getMaskNumberPhone() {
        return "+79999999999";
    }
}

//