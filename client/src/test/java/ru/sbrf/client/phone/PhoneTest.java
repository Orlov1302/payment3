package ru.sbrf.client.phone;

import org.junit.jupiter.api.Test;
import ru.sbrf.client.user.User;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    public void test_1() {
        Phone phone = new Phone("9O57770377", "9999999999");
        assertTrue( phone.validationPhone().length() > 0);
    }

    @Test
    public void test_2() {
        Phone phone = new Phone("9057770377", "9999999999");
        assertEquals( phone.validationPhone().length(), 0);
    }
}

////