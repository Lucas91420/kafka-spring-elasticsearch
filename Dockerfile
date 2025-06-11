# Utilise l'image officielle Java 17 (adaptée à ton projet)
FROM openjdk:17-jdk-slim

# Crée un répertoire pour l'app
WORKDIR /app

# Copie le JAR généré par Maven
COPY target/kafka-0.0.1-SNAPSHOT.jar app.jar

# Démarre l'app
ENTRYPOINT ["java", "-jar", "app.jar"]

