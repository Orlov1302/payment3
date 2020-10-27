package ru.sbrf.client.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sbrf.client.phone.Phone;
import ru.sbrf.client.phone.ValidationFuncOfPhoneStrong;
import ru.sbrf.client.service.Putting;
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
        user.setPhone(new Phone("+79057770377", "+79999999999" ));
        System.out.println(" ----------------- Тестирование номера телефона -------------------- ");
        Phone phone = new Phone("+89057770377", "+79999999999" );
        System.out.println( phone.validationPhone() );
        System.out.println( phone.validationPhone(ValidationFuncOfPhoneStrong::func) );
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
