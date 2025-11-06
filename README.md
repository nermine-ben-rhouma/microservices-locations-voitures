# 🚗 Rental Microservices (Spring Boot + Eureka + Gateway + Kafka + Docker)

Projet complet basé sur une architecture microservices permettant la gestion d’une application de location de voitures.  
Il inclut 3 microservices + un serveur Eureka + un API Gateway + un système de communication via Kafka + déploiement via Docker.

---

## 🧱 Architecture

- **Eureka Server** : Service registry (8761)
- **API Gateway** : Point d’entrée unique, routing dynamique (8888)
- **Client Service** : Gestion des clients (8084)
- **Vehicle Service** : Gestion des véhicules + Kafka Consumer (8085)
- **Rental Service** : Gestion des locations + Kafka Producer (8086)
- **Kafka + Zookeeper** : Communication événementielle

---

## 🛠️ Technologies utilisées

| Catégorie | Technologie |
|-----------|-------------|
| Backend | Spring Boot 3 / Java 17 |
| Microservices | Spring Cloud Eureka, OpenFeign, Gateway |
| Messaging | Apache Kafka |
| Base de données | H2 (mode mémoire) |
| Build & Packaging | Maven |
| Déploiement | Docker & Docker Compose |

---

## 🚀 Démarrer le projet

### ▶️ Mode Docker (recommandé)

```sh
docker-compose up --build
