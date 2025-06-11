package com.learn.kafka.service;

import com.learn.kafka.api.ExchangeRateClient;
import com.learn.kafka.elastic.ExchangeRateDocument;
import com.learn.kafka.elastic.ExchangeRateRepository;
import com.learn.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateClient apiClient;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private ExchangeRateRepository elasticsearch;

    @Scheduled(fixedRate = 120000)
    public void scheduledFetchAndPush() {
        System.out.println("Tâche planifiée : récupération des taux de change...");
        fetchAndDistributeRates();
    }

    public void fetchAndDistributeRates() {
        try {
            // Correction ici : Map<String, Object>
            Map<String, Object> rates = apiClient.getRates();
            System.out.println("Rates fetched: " + rates);

            rates.forEach((currency, value) -> {
                try {
                    // Correction ici : conversion sûre
                    Double rate = value instanceof Number ? ((Number) value).doubleValue() : null;
                    if (rate != null) {
                        System.out.println("Processing rate for: " + currency + " = " + rate);

                        // 1. Envoyer dans Kafka
                        messageProducer.sendMessage("exchange-rates", currency + ":" + rate);

                        // 2. Sauvegarder dans Elasticsearch
                        ExchangeRateDocument doc = new ExchangeRateDocument();
                        doc.setId(UUID.randomUUID().toString());
                        doc.setCurrency(currency);
                        doc.setRate(rate);
                        doc.setTimestamp(Instant.now().toString());
                        elasticsearch.save(doc);
                    } else {
                        System.err.println("Invalid rate for currency: " + currency + " -> Skipping.");
                    }

                } catch (Exception e) {
                    System.err.println("Error processing currency: " + currency + " -> " + e.getMessage());
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            System.err.println("Error fetching rates: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
