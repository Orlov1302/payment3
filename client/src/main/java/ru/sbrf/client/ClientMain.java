package ru.sbrf.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sbrf.client.user.UserTesting;

@SpringBootApplication
public class ClientMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClientMain.class, args);
        context.getBean(UserTesting.class).run(); //Запуск демонстрации работы программы
    }
}

////