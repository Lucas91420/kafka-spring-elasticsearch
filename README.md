# Kafka Spring Elasticsearch App

Une application Java basée sur **Spring Boot**, **Apache Kafka** et **Elasticsearch**, orchestrée via **Docker Compose**. Elle permet de consommer des données depuis une API de taux de change, de les produire dans un topic Kafka, puis de les indexer automatiquement dans Elasticsearch.

---

## Fonctionnalités

-  Appel régulier à une API de taux de change
-  Envoi des données dans un topic Kafka (`exchange-rates`)
-  Consommation des messages Kafka dans un consumer Spring
-  Indexation automatique dans Elasticsearch
- 📊Visualisation via Kibana

---

## Stack technique

- Java 17 (via Spring Boot 3)
- Apache Kafka (via Docker)
- Zookeeper (via Docker)
- Elasticsearch 8
- Kibana 8
- Docker Compose
- Maven

---

##  Structure du projet

kafka-kata/
│
├── src/
│ ├── main/java/com/learn/kafka/
│ └── main/resources/
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md





---

##  Lancer le projet avec Docker Compose

Assurez-vous que **Docker** est installé, puis exécute :


docker compose up --build


Cela va :

    Builder l’image de l’application

    Démarrer les services suivants :

        Zookeeper

        Kafka

        Elasticsearch

        Kibana

        L'application Spring Boot


Accès aux interfaces

    Kibana : http://localhost:5601

    Elasticsearch : http://localhost:9200

    Application Spring Boot : http://localhost:8080




    Variables d’environnement principales

Ces variables sont définies dans docker-compose.yml :

SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092
SPRING_ELASTICSEARCH_URIS=http://elasticsearch:9200




Prérequis

    Docker + Docker Compose

    (optionnel) Maven si build en local : ./mvnw clean package



     Auteur

Lucas — github.com/Lucas91420


Licence

Ce projet est libre d’usage dans un cadre pédagogique.


---

Souhaites-tu que je t’envoie également un `.gitignore` adapté pour ton projet Java + Docker ?

