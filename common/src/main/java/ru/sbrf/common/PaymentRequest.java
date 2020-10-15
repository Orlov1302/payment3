package ru.sbrf.common;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
//@Value
public class PaymentRequest {
    private Date date;
    private String numberAccount;
    private String numberPhone;
    private long summa;
    private Currency currency;
}

////
