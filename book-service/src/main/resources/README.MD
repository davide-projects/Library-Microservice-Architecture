# 📚 Apulia Library — Microservices Project

Ecosistema di microservizi per la gestione di una biblioteca digitale, sviluppato con **Java 17** e **Spring Boot 3**.
 
---

## 🧩 Architettura

Il progetto è composto da tre microservizi indipendenti:

| Servizio | Descrizione | Repository |
|---|---|---|
| 📘 Book Service | Gestione del catalogo libri | `book-service` |
| 🧑‍🤝‍🧑 Member Service | Gestione degli utenti iscritti | `member-service` |
| 📄 Loan Service | Gestione dei prestiti | `loan-service` |
 
---

## 🛠️ Tecnologie utilizzate

- Java 17
- Spring Boot 3
- Spring Web
- Spring Validation
- Springdoc OpenAPI (da integrare)
- Maven
---

## 📦 Installazione generale

Clonare le repository dei singoli servizi e avviarli separatamente:

```bash
git clone https://github.com/davide-projects/book-service.git
git clone https://github.com/davide-projects/member-service.git
git clone https://github.com/davide-projects/loan-service.git
```

Per ogni servizio:

```bash
cd <nome-servizio>
mvn spring-boot:run
```
 
---

## 📘 Book Service

Microservizio dedicato alla gestione dei libri.

### Funzionalità principali
- CRUD completo dei libri
- Ricerca per titolo e autore
- DTO per esposizione sicura dei dati
- Validazione input
- Gestione errori centralizzata
- Pronto per integrazione Swagger/OpenAPI
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/book` | Lista libri |
| GET | `/book/{id}` | Libro per ID |
| POST | `/book` | Crea libro |
| PUT | `/book/{id}` | Aggiorna libro |
| PATCH | `/book/{id}` | Aggiornamento parziale |
| DELETE | `/book/{id}` | Elimina libro |
| GET | `/book/search` | Ricerca |
 
---

## 🧑‍🤝‍🧑 Member Service

Microservizio dedicato alla gestione degli utenti iscritti alla biblioteca.

### Funzionalità principali
- CRUD completo dei membri
- Ricerca per nome o email
- Validazione input
- Gestione errori centralizzata
- Pronto per integrazione Swagger/OpenAPI
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/member` | Lista membri |
| GET | `/member/{id}` | Membro per ID |
| POST | `/member` | Crea membro |
| PUT | `/member/{id}` | Aggiorna membro |
| PATCH | `/member/{id}` | Aggiornamento parziale |
| DELETE | `/member/{id}` | Elimina membro |
| GET | `/member/search` | Ricerca |
 
---

## 📄 Loan Service

Microservizio dedicato alla gestione dei prestiti dei libri.

### Funzionalità principali
- Creazione prestiti
- Restituzione libri
- Verifica stato prestito
- Validazione input
- Gestione errori centralizzata
- Pronto per integrazione Swagger/OpenAPI
### Endpoints

| Metodo | Endpoint | Descrizione |
|---|---|---|
| GET | `/loan` | Lista prestiti |
| GET | `/loan/{id}` | Prestito per ID |
| POST | `/loan` | Crea prestito |
| PUT | `/loan/{id}` | Aggiorna prestito |
| PATCH | `/loan/{id}` | Aggiornamento parziale |
| DELETE | `/loan/{id}` | Elimina prestito |
| GET | `/loan/member/{id}` | Prestiti per membro |
 
---

## 🧱 Struttura progetto (per ogni servizio)

```
controller/
dto/
model/
service/
exception/
```
 
---

## 📘 Documentazione API

Da integrare con Swagger/OpenAPI per ogni microservizio.
 
---

## 📝 TO-DO

- [ ] Integrare Swagger/OpenAPI
- [ ] Aggiungere esempi negli endpoint
- [ ] Aggiungere test unitari
- [ ] Validazioni aggiuntive nel Loan Service (ritardi, scadenze, ecc.)
- [ ] Definire comunicazione tra microservizi (REST/Feign/Eventi)
---

## 📄 Licenza

Vedi il file `LICENSE` in ciascuna repository.
 
---

## 👨‍💻 Autore

**Davide** — Apulia Library Project