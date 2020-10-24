package ru.sbrf.client.phone;

public class ValidationFuncOfPhone_Standart {
   public static String func(Phone t) {
       if ( t == null || t.getNumberPhone() == null || t.getNumberPhone().isEmpty() ) {
           return "Номер телефона пуст.";
       } else {
           String maskNumberPhone = t.getMaskNumberPhone();
           if (maskNumberPhone == null) {
                return "Маска номера телефона не задана.";
           } else if ( !maskNumberPhone.isEmpty()) {
               boolean errorFormat = false;
               if (t.getNumberPhone().length() != maskNumberPhone.length()) {
                   errorFormat = true;
               } else {
                   for (int x = 0; x < maskNumberPhone.length(); ++x) {
                       char cF = maskNumberPhone.charAt(x);
                       char cN = t.getNumberPhone().charAt(x);
                       if ('0' <= cF && cF <= '9') {
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

//