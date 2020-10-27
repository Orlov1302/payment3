package ru.sbrf.client.phone;

public class ValidationFuncOfPhoneStrong {
    public static String func( String numberPhone, String maskNumberPhone ) {
        if ( numberPhone == null || numberPhone.isEmpty() ) {
            return "Номер телефона пуст.";
        } else {
            if (maskNumberPhone == null) {
                return "Маска номера телефона не задана.";
            } else if ( !maskNumberPhone.isEmpty()) {
                boolean errorFormat = false;
                if (numberPhone.length() != maskNumberPhone.length()) {
                    errorFormat = true;
                } else {
                    for (int x = 0; x < maskNumberPhone.length(); ++x) {
                        char cF = maskNumberPhone.charAt(x);
                        char cN = numberPhone.charAt(x);
                        if (cF == '9') {  // Единственное отличие от стандартной функции
                            if (!('0' <= cN && cN <= '9')) {
                                errorFormat = true;
                                break;
                            }
                        } else if (cN != cF) {
                            errorFormat = true;
                            break;
                        }
                    }
                }
                if (errorFormat) {
                    return "Телефонный номер должен быть формата " + maskNumberPhone;
                }
            }
        }
        return "";
    }
}

////