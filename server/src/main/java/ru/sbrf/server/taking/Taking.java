package ru.sbrf.server.taking;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.common.PaymentRequest;
import ru.sbrf.common.PaymentResponse;
import ru.sbrf.server.service.Server;

@RestController
@AllArgsConstructor
public class Taking {
    private Server server;

    @PostMapping("/pay")
    public PaymentResponse takePayment( @RequestBody PaymentRequest request) {
        PaymentResponse response = server.pay(request);
        System.out.println("========================================= ");
        System.out.println( request.getDate() + ", " + request.getNumberAccount() + ", " +
                request.getNumberPhone() + ", " + request.getSumma() + ", " + request.getCurrency() );
        System.out.println( response.getComment() );
        System.out.println("========================================= ");
        return response;
    }
}

////