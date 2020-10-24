package ru.sbrf.client.putting;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbrf.common.PaymentRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Putting {
    public void putPayment(PaymentRequest paymentRequest){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PaymentRequest> request = new HttpEntity<>(paymentRequest);
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity("http://127.0.0.1:9091/pay", request, String.class);
        System.out.println("========================================= ");
        System.out.println(responseEntity.getBody());
        if( responseEntity.getStatusCode() == HttpStatus.OK ) {
            try {
                JSONObject resp = new JSONObject(responseEntity.getBody());
                if( resp.getBoolean("success") ){
                    System.out.println("<<< Платёж выпонен >>>");
                }else {
                    System.out.println("<<< Платёж не выпонен >>>");
                }
            } catch (JSONException e) {
                System.out.println(" Ошибка расшифровки JSON ");
            }
        }
        System.out.println("========================================= ");
    }
}

//
