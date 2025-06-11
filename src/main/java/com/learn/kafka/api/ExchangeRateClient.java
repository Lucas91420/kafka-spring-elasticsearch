package com.learn.kafka.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Composant Spring permettant de consommer une API externe pour récupérer les taux de change.
 */
@Component
public class ExchangeRateClient {

    // URL de l'API publique pour les taux de change par rapport au dollar américain (USD)
    private final String apiUrl = "https://api.exchangerate-api.com/v4/latest/USD";

    /**
     * Méthode qui interroge l'API et retourne une map contenant les taux de change.
     * Clé = code de devise (ex: "EUR"), Valeur = taux de change par rapport au USD
     *
     * @return Map<String, Object> contenant les taux de change
     */
    public Map<String, Object> getRates()
    {
        // Log : on affiche l'URL appelée
        System.out.println("Calling API: " + apiUrl);

        // Création d'un client HTTP simple (RestTemplate)
        RestTemplate restTemplate = new RestTemplate();

        // Appel de l'API : le résultat est un objet de type Map (JSON désérialisé en map Java)
        Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);

        // Log : on affiche toute la réponse brute
        System.out.println("API reponse: " + response);

        // On extrait et retourne uniquement la partie "rates" du JSON, qui contient les taux
        return (Map<String, Object>) response.get("rates");
    }
}
