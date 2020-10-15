package ru.sbrf.client.phone;

import org.junit.jupiter.api.Test;
import ru.sbrf.client.user.User;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    public User user1;

    public void before() {
        user1 = new User();
        user1.setNumberAccount("1234500001");
    }

    @Test
    public void test_1() {
        before(); // Если убрать, то тест не будет пройден.
        user1.setPhone(new PhoneOnlyDigits("9O57770377"));
        assertNotEquals(user1.validationPhone().substring(0,10), "Исключение");
    }

    @Test
    public void test_2() {
        before(); // Если убрать, то тест не будет пройден.
        user1.setPhone(new PhoneOnlyDigits("9057770377"));
        assertEquals(user1.validationPhone().substring(0,7), "Телефон");
    }
}

////