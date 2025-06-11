package com.learn.kafka;

import com.learn.kafka.producer.MessageProducer;
import com.learn.kafka.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private ExchangeRateService exchangeRateService;

    // Ancienne méthode : envoie d'un message simple
    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestParam("content") String content) {
        messageProducer.sendMessage("mon-tunnel-topic", content);
        return ResponseEntity.ok("Message envoyé : " + content);
    }

    // Méthode améliorée: appelle l'API externe et publie tout

    @RequestMapping(value = "/rates/fetch", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> fetchAndPush() {
        exchangeRateService.fetchAndDistributeRates();
        return ResponseEntity.ok("Rates fetched and sent!");
    }
}
