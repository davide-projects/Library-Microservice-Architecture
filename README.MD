# 📚 Apulia Library — Microservices Project

Ecosistema di microservizi per la gestione di una biblioteca digitale, sviluppato con **Java 21** e **Spring Boot 4**.
 
---

## 🧩 Architettura

Il progetto è composto da tre microservizi indipendenti organizzati in un progetto Maven multi-modulo:

| Servizio | Descrizione | Porta |
|---|---|---|
| 📘 Book Service | Gestione del catalogo libri | `8081` |
| 🧑‍🤝‍🧑 Member Service | Gestione degli utenti iscritti | `8082` |
| 📄 Loan Service | Gestione dei prestiti | `8083` |
 
---

## 🛠️ Tecnologie utilizzate

- Java 21
- Spring Boot 4.1.0
- Spring Web
- Spring Data JPA + Hibernate
- Spring Security (Book Service)
- Spring Validation
- Springdoc OpenAPI 2.8.9
- MySQL 8
- Lombok
- Maven (struttura multi-modulo)
---

## 📦 Installazione

Clonare il repository del progetto:

```bash
git clone https://github.com/davide-projects/Library-Microservice-Architecture.git
cd Library-Microservice-Architecture
```

Avviare ogni microservizio separatamente da IntelliJ oppure da terminale:

```bash
cd book-service
.\mvnw spring-boot:run
 
cd member-service
.\mvnw spring-boot:run
 
cd loan-service
.\mvnw spring-boot:run
```
 
---

## 📘 Book Service

Microservizio dedicato alla gestione del catalogo libri.

### Funzionalità principali
- CRUD completo dei libri
- Ricerca per titolo e/o autore
- Validazione input
- Gestione errori centralizzata con logging SLF4J
- Documentazione API con Swagger/OpenAPI
- Spring Security configurato (accesso pubblico)
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/book` | Lista libri |
| GET | `/book/{id}` | Libro per ID |
| GET | `/book/search` | Ricerca per titolo e/o autore |
| POST | `/book` | Crea libro |
| PUT | `/book/{id}` | Aggiorna libro |
| PATCH | `/book/{id}` | Aggiornamento parziale |
| DELETE | `/book/{id}` | Elimina libro |

### Documentazione API
```
http://localhost:8081/swagger-ui/index.html
http://localhost:8081/v3/api-docs
```
 
---

## 🧑‍🤝‍🧑 Member Service

Microservizio dedicato alla gestione degli utenti iscritti alla biblioteca.

### Funzionalità principali
- CRUD completo dei membri
- Validazione input
- Gestione errori centralizzata con logging SLF4J
- Documentazione API con Swagger/OpenAPI
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/members` | Lista membri |
| GET | `/members/{id}` | Membro per ID |
| POST | `/members` | Crea membro |
| PUT | `/members/{id}` | Aggiorna membro |
| PATCH | `/members/{id}` | Aggiornamento parziale |
| DELETE | `/members/{id}` | Elimina membro |

### Documentazione API
```
http://localhost:8082/swagger-ui/index.html
http://localhost:8082/v3/api-docs
```
 
---

## 📄 Loan Service

Microservizio dedicato alla gestione dei prestiti, con comunicazione REST verso Book Service e Member Service.

### Funzionalità principali
- Creazione prestiti multipli
- Restituzione libri
- Verifica disponibilità libro tramite Book Service
- Verifica esistenza membro tramite Member Service
- Dettagli prestito arricchiti con dati di libro e membro
- Validazione input
- Gestione errori centralizzata con logging SLF4J
- Documentazione API con Swagger/OpenAPI
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/loans` | Lista prestiti |
| GET | `/loans/{id}` | Prestito per ID |
| GET | `/loans/details` | Lista prestiti con dettagli libro e membro |
| GET | `/loans/details/{id}` | Dettaglio singolo prestito |
| POST | `/loans` | Crea prestiti |
| PATCH | `/loans/{id}/return` | Restituisce libro |
| DELETE | `/loans/{id}` | Elimina prestito |

### Documentazione API
```
http://localhost:8083/swagger-ui/index.html
http://localhost:8083/v3/api-docs
```
 
---

## 🧱 Struttura progetto

```
Library-Microservice-Architecture/
├── pom.xml                  (parent multi-modulo)
├── book-service/
│   └── src/main/java/com/apulia/bookservice/
│       ├── config/
│       ├── controller/
│       ├── dto/
│       ├── model/
│       ├── repository/
│       ├── security/
│       ├── service/
│       └── exception/
├── member-service/
│   └── src/main/java/com/apulia/memberservice/
│       ├── config/
│       ├── controller/
│       ├── dto/
│       ├── model/
│       ├── repository/
│       ├── service/
│       └── exception/
└── loan-service/
    └── src/main/java/com/apulia/loanservice/
        ├── client/
        ├── config/
        ├── controller/
        ├── dto/
        ├── model/
        ├── repository/
        ├── service/
        └── exception/
```
 
---

## 📝 TO-DO

- [ ] Aggiungere API Gateway
- [ ] Containerizzare con Docker
---

## 📄 Licenza

Vedi il file `LICENSE` nella repository.
 
---

## 👨‍💻 Autore

**Davide** — Apulia Library Project
 