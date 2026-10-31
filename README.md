# StarConnect

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-6db33f)](https://spring.io/projects/spring-boot)
![Java](https://img.shields.io/badge/Java-21-ed8b00)
![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-010101)
![Thymeleaf](https://img.shields.io/badge/UI-Thymeleaf-005f0f)

A simple **real-time chat** application built with Spring Boot, WebSocket (STOMP) and Thymeleaf. A compact, readable example of server-pushed messaging in the Spring ecosystem.

## Features

- Real-time messaging over **WebSocket / STOMP** (`WebSocketConfig`, `ChatController`).
- Users and messages persisted with Spring Data JPA (H2 in-memory for development).
- Join / leave events handled via a `WebSocketEventListener`.
- Server-rendered UI with Thymeleaf; a small REST surface (`ApiController`).

## Tech stack

Spring Boot 3 · Java 21 · Spring WebSocket · Spring Data JPA · Thymeleaf · H2 · Lombok.

## Run

```bash
git clone https://github.com/GAUSS-TPAC/StarConnect.git && cd StarConnect
./mvnw spring-boot:run      # http://localhost:8080
```

The H2 in-memory database is created on startup; no external database needed to try it.

## Structure

```
controller/   ChatController (STOMP), ApiController (REST), webController (pages)
service/      UserService, MessageService
entities/     User, Message        repository/  UsersRepository, MessagesRepository
config/       WebSocketConfig, WebSocketEventListener
```

## License

Released under the MIT License.
