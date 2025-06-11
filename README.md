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


Lien vidéo : https://teams.microsoft.com/l/meetingrecap?driveId=b%210mK5ibnpf0u4lu-L5rHhxtQOIykBAFZNlSHM9MBHaA5kpc6l_CArT7zO3MkJ_Nt2&driveItemId=01WJMBLM6UK5OY6S3B25FILYTV3R4HTQH6&sitePath=https%3A%2F%2Fensup-my.sharepoint.com%2F%3Av%3A%2Fg%2Fpersonal%2Flucas_varsavaux_ensitech_eu%2FEdRXXY9LYddKheJ13Hh5wP4BaPlj790rPnpK_1fd5Twi5g&fileUrl=https%3A%2F%2Fensup-my.sharepoint.com%2F%3Av%3A%2Fg%2Fpersonal%2Flucas_varsavaux_ensitech_eu%2FEdRXXY9LYddKheJ13Hh5wP4BaPlj790rPnpK_1fd5Twi5g&threadId=19%3Ameeting_MmQ4YzhkNGItNzliNy00YmRjLTkxNDYtN2ZiMTBjNDBkZjJi%40thread.v2&organizerId=78bb88d2-4cb1-40a4-8203-c95963549539&tenantId=9840a2a0-6ae1-4688-b03d-d2ec291be0f9&callId=eb4ea303-6bac-4070-9fd8-e52d5203f31d&threadType=Meeting&meetingType=MeetNow&subType=RecapSharingLink_RecapChiclet
