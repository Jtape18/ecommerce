# 🛒 E-commerce API (Backend)

API RESTful para gerenciamento de um sistema de e-commerce, desenvolvida com Java + Spring Boot utilizando Clean Architecture, PostgreSQL e Swagger UI.

---

## 🚀 Funcionalidades

- Cadastro e listagem de usuários
- Cadastro e listagem de produtos
- Carrinho de compras por usuário
- Checkout de pedidos com cálculo de total
- Histórico de pedidos e detalhes por ID
- Atualização de status (admin)
- Pagamento fictício
- Validações de regra de negócio (estoque, quantidade, etc.)

---

## 📚 Tecnologias

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL (via Docker)
- SpringDoc OpenAPI (Swagger)
- Maven

---

## 🐳 Docker

```bash
docker-compose up -d
```

---

## 🔧 Configuração

Configure o `application.properties` com:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

## 📑 Documentação Swagger

Acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Teste no Postman

Importe a collection `ecommerce-api.postman_collection.json` (opcional)

---

## 📂 Estrutura do Projeto

```
src/main/java/com/josepaulo/ecommerce
├── application/useCases
├── domain/entities
├── domain/repositories
├── domain/enums
├── infra/database/repositories/jpa
├── interfaces/controller
├── interfaces/dto
└── config
```

---

## 🧠 Padrões Utilizados

- Clean Architecture
- DTOs para entrada e saída
- Validação com Jakarta Validation
- Convention Commits (`feat:`, `fix:`, `docs:` etc.)
