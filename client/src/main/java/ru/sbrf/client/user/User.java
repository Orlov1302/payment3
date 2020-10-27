package ru.sbrf.client.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.sbrf.common.*;
import ru.sbrf.client.phone.Phone;

import java.util.Date;

@Setter
@Getter
@Component
public class User {
    private long numberUser;
    private String stringFIO;
    private String numberAccount;
    private Phone phone;

    public User(){
        this.numberUser = 0;
        this.stringFIO = "нет";
    }

    public PaymentRequest getParametersPayment(Date date, int summa, Currency currency ){
        if( numberAccount == null || phone == null || date == null ){
            return new PaymentRequest(new Date(),"", "", 0, currency);
        }else{
            return new PaymentRequest(date, numberAccount, phone.getNumberPhone(), summa, currency);
        }
    }

}

////
