package ru.sbrf.client.phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Phone {
    private String numberPhone;
    private String maskNumberPhone;

    // Проверка валидности телефонного номера стандартной функцией
    public String validationPhone() {
        return ValidationFuncOfPhoneStandart.func( numberPhone, maskNumberPhone );
    }

    // Проверка валидности телефонного номера пользовательской функцией
    public String validationPhone(ValidationFuncOfPhone validationFunc){
        return validationFunc.func( numberPhone, maskNumberPhone );
    }

}
//