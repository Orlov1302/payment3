package ru.sbrf.server.server;

import org.springframework.stereotype.Service;
import ru.sbrf.common.PaymentRequest;
import ru.sbrf.common.PaymentResponse;

import java.util.HashSet;

@Service
public class Server {
    private HashSet<PaymentRequest> oldPayments; // Здесь храняться старые запросы

    public Server() {
        oldPayments = new HashSet<>();
    }

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        boolean success = false;
        String comment = "Платеж со счета " + paymentRequest.getNumberAccount() +
                " на телефон " + paymentRequest.getNumberPhone();
        if (oldPayments.contains(paymentRequest)) {
            comment += " не выполнен. Запрос поступил повторно!!!";
        } else {
            comment += " выполнен.";
            oldPayments.add(paymentRequest);
            success = true;
        }
        return new PaymentResponse(success, comment);
    }
}

////