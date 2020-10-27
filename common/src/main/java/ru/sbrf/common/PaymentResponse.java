package ru.sbrf.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PaymentResponse {
    private boolean success;
    private String comment;
}

//