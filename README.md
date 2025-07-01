# 🌌 Clínica Nebulosa Estelar

## 🇧🇷 Sobre o Projeto

A **Clínica Nebulosa Estelar** é uma API RESTful desenvolvida em **Java 17** com **Spring Boot** e **PostgreSQL**, voltada para o gerenciamento de uma clínica veterinária. O sistema permite a administração completa de **animais**, seus **tutores (responsáveis)**, **veterinários** e **consultas clínicas**.

Este projeto foi desenvolvido seguindo os princípios de **Clean Code**, com foco em **legibilidade**, **manutenção**, **separação de responsabilidades**, e boas práticas de modelagem de dados e REST.

## 🧠 Detalhes Técnicos

- Camada de entidades (JPA) bem estruturada com **validações** e **anotações padrão**
- Regras de negócio centralizadas na camada `service`
- Controle via `controller` RESTful com retorno adequado de status HTTP
- Utilização de `DTOs` onde necessário
- Documentação da API com **Swagger (OpenAPI)**

## 🧩 Relacionamentos no Banco de Dados

A modelagem relacional do sistema representa fielmente o domínio da clínica veterinária:

- **Animal**
  - Pertence a um único **Tutor** → `@ManyToOne`
  - Pode ter várias **Consultas** → `@OneToMany`

- **Tutor**
  - Pode ter vários **Animais** → `@OneToMany`

- **Consulta**
  - Relaciona-se a um **Veterinário** e a um **Animal** → `@ManyToOne` para ambos

- **Veterinário**
  - Pode atender diversas **Consultas** → `@OneToMany`

Esse modelo permite consultas otimizadas, integridade referencial e facilidade na recuperação de dados complexos, como “todas as consultas de um animal específico” ou “tutores com múltiplos animais”.

## 📄 Funcionalidades da API

- ✅ Cadastro, listagem, atualização e exclusão de:
  - Animais
  - Tutores (responsáveis)
  - Veterinários
  - Consultas clínicas
- 🔍 Consulta por ID
- 📚 Documentação interativa com Swagger
- ⚠️ Retornos HTTP adequados para validações e erros

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger/OpenAPI
- Maven

## 💡 Boas Práticas e Arquitetura

- Clean Code e SOLID aplicados
- Responsabilidades separadas (Controller, Service, Repository)
- Validações com `@Valid`, `@NotNull`, `@Size`, etc.
- Uso de `ResponseEntity` para controle de status HTTP
- Estrutura de pacotes limpa e intuitiva

---

## 🇺🇸 About the Project

**Clínica Nebulosa Estelar** is a RESTful API built in **Java 17** with **Spring Boot** and **PostgreSQL**, designed to manage a veterinary clinic. The system supports full administration of **animals**, their **tutors (owners)**, **veterinarians**, and **medical consultations**.

The codebase adheres strictly to **Clean Code principles**, ensuring maintainability, readability, and scalability.

## 🧠 Technical Overview

- Well-defined entity layer with **JPA annotations** and **validation**
- Business logic encapsulated in the `service` layer
- RESTful controllers with appropriate HTTP status handling
- Use of DTOs when needed
- API documented using **Swagger/OpenAPI**

## 🧩 Database Relationships

The relational model is fully aligned with the domain logic:

- **Animal**
  - Belongs to a single **Tutor** → `@ManyToOne`
  - Can have multiple **Consultations** → `@OneToMany`

- **Tutor**
  - Can own multiple **Animals** → `@OneToMany`

- **Consultation**
  - Linked to both a **Veterinarian** and an **Animal** → `@ManyToOne`

- **Veterinarian**
  - Can attend multiple **Consultations** → `@OneToMany`

These relationships ensure data integrity and allow complex queries such as “all consultations for a specific animal” or “owners with multiple animals”.

## 📄 API Features

- ✅ CRUD operations for:
  - Animals
  - Tutors
  - Veterinarians
  - Consultations
- 🔍 Find by ID
- 📚 Interactive API docs with Swagger
- ⚠️ Proper HTTP responses and validation errors

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger/OpenAPI
- Maven

## 💡 Best Practices & Architecture

- Clean Code + SOLID
- Separation of concerns (Controller, Service, Repository)
- Validation with annotations
- ResponseEntity for HTTP control
- Organized and scalable project structure

---

📝 **Licença:** Projeto livre para fins de estudo e demonstração no portfólio.

