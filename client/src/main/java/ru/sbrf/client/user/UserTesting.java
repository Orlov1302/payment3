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
        user.setNumberUser(1); //Установка переменной, которая потом не используется
        user.setStringFIO("Иванов иван Иванович"); //Установка переменной, которая потом не используется
        user.setNumberAccount("1110222");
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
        Date date;
        PaymentRequest paymentRequest;
        date = new Date();
        paymentRequest = user.getParametersPayment(date, 1400, Currency.RUB );
        putting.putPayment(paymentRequest);
        putting.putPayment(paymentRequest);
        date = new Date();
        paymentRequest = user.getParametersPayment(date, 900, Currency.RUB );
        putting.putPayment(paymentRequest);
        System.out.println(" ------------------------------------------------------------------- ");
    }
}

////
