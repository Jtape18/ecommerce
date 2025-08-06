# 🛒 E-commerce API

API REST para gerenciamento de e-commerce desenvolvida com **Java + Spring Boot**, seguindo os princípios de **Clean Architecture**. Este projeto permite o cadastro de produtos, gerenciamento de pedidos, controle de estoque e autenticação de usuários via JWT.

---

## 🚀 Funcionalidades

- ✅ Registro e login de usuários com JWT
- ✅ Autenticação e autorização por perfil (ROLE_USER, ROLE_ADMIN)
- ✅ CRUD de produtos
- ✅ Criação e gerenciamento de pedidos
- ✅ Atualização de estoque automática no checkout
- ✅ Relatório de vendas por período
- ✅ Integração com banco PostgreSQL
- ✅ Documentação Swagger

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security + JWT
- Maven
- PostgreSQL
- Docker
- Swagger (SpringDoc OpenAPI)
- Render (Deploy)

---

## 📁 Estrutura de pastas (Clean Architecture)

```
src
├── application
│   └── useCases         # Casos de uso (regras de negócio)
├── domain
│   ├── entities         # Entidades do domínio
│   ├── enums            # Enums como OrderStatus, Role etc.
│   └── repositories     # Interfaces dos repositórios
├── infra
│   └── database
│       └── repositories # Implementações JPA dos repositórios
├── interfaces
│   ├── controller       # Controllers REST
│   └── dto              # DTOs de entrada e saída
└── config               # Configurações (Security, Swagger, etc)
```

---

## 💻 Rodando localmente

### Pré-requisitos:
- Java 17+
- Docker
- Maven

### Passos:

```bash
# 1. Clonar o repositório
git clone https://github.com/Jtape18/ecommerce.git
cd ecommerce

# 2. Subir o banco de dados
docker-compose up -d

# 3. Rodar a aplicação
./mvnw spring-boot:run
```

---

## 🔐 Autenticação JWT

- Registre um usuário: `POST /auth/register`
- Faça login: `POST /auth/login`
- Copie o token e utilize como Bearer Token nas demais rotas protegidas

---

## 📄 Documentação Swagger

Acesse:

```
http://localhost:8080/swagger-ui/index.html
```

Ou, se estiver hospedado no Render:

```
https://ecommerce-1-7tjy.onrender.com/swagger-ui/index.html```
```
---

## ☁️ Deploy no Render

- Banco PostgreSQL criado no painel Render
- Dockerfile configurado na raiz do projeto
- Variáveis de ambiente adicionadas via dashboard:
    - `SPRING_DATASOURCE_URL`
    - `SPRING_DATASOURCE_USERNAME`
    - `SPRING_DATASOURCE_PASSWORD`

---



## 🧑‍💻 Autor

[José Matias](https://www.linkedin.com/in/jtape18/)  
Back-end Developer • Java • Spring Boot • Clean Architecture

---