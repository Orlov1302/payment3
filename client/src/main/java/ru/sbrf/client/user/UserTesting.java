package ru.sbrf.client.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sbrf.client.phone.Phone;
import ru.sbrf.client.phone.PhoneOnlyDigits;
import ru.sbrf.client.phone.PhonePlusAndDigits;
import ru.sbrf.client.phone.ValidationFuncOfPhone_Strong;
import ru.sbrf.client.putting.Putting;
import ru.sbrf.common.Currency;
import ru.sbrf.common.PaymentRequest;

import java.util.Date;

@Component
@AllArgsConstructor
public class UserTesting {
    private User user;
    private Putting putting;

    public void run(){
        user.setNumberUser(123); //Установка переменной, которая потом не используется
        user.setStringFIO("Иванов иван Иванович"); //Установка переменной, которая потом не используется
        user.setNumberAccount("1234500001"); //Установка переменной, которая потом не используется
        System.out.println(" ----------------- Тестирование номера телефона -------------------- ");
        user.setPhone(new PhoneOnlyDigits("9O57770377"));
        System.out.println( user.validationPhone() );
        user.setPhone(new PhonePlusAndDigits("+89057770377"));
        System.out.println( user.validationPhone() );
        System.out.println( user.validationPhone(ValidationFuncOfPhone_Strong::func) );
        user.setPhone(new PhonePlusAndDigits("+79057770555"));
        System.out.println( user.validationPhone(ValidationFuncOfPhone_Strong::func) );
        System.out.println( user.validationPhone((Phone t)->"Все номера телефонов плохие"));
        System.out.println(" ----------------- Тестирование платежей --------------------------- ");
        Date date = new Date();
        PaymentRequest paymentRequest1 = user.getParametersPayment(date, 400, Currency.RUB );
        putting.putPayment(paymentRequest1);
        putting.putPayment(paymentRequest1);
        System.out.println(" ------------------------------------------------------------------- ");
    }
}

////
