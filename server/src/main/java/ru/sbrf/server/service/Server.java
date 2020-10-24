package ru.sbrf.server.service;

import org.springframework.stereotype.Service;
import ru.sbrf.common.PaymentRequest;
import ru.sbrf.common.PaymentResponse;
import ru.sbrf.server.entity.Account;
import java.util.HashSet;

@Service
public class Server {
    private AccountService accountService;
    private HashSet<PaymentRequest> oldPayments; // Здесь храняться старые запросы

    public Server( final AccountService accountService ) {
        this.accountService = accountService;
        oldPayments = new HashSet<>();
    }

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        boolean success = false;
        String comment = "Платеж со счета " + paymentRequest.getNumberAccount() +
                " на телефон " + paymentRequest.getNumberPhone();
        if (oldPayments.contains(paymentRequest)) {
            comment += " не выполнен. Запрос поступил повторно!!!";
        } else {
            Account account = accountService.getAccount(paymentRequest.getNumberAccount());
            if( account==null || account.getNumber().equals("") ){
                comment += " не выполнен. Счет не найден. ";
            } else {
                int newBalance = account.getBalance() - paymentRequest.getSumma();
                if( newBalance < 0 ){
                    comment += " не выполнен. Недостаточно средств. ";
                } else {
                    account.setBalance(newBalance);
                    accountService.putAccount(account);
                    comment += " выполнен. Остаток на счету: " + newBalance;
                    oldPayments.add(paymentRequest);
                    success = true;
                }
            }
        }
        return new PaymentResponse(success, comment);
    }
}

////