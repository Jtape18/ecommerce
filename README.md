# 🛒 E-commerce API

API RESTful para gerenciamento de um sistema de E-commerce, construída com Java + Spring Boot, seguindo os princípios da Clean Architecture.

## 📦 Funcionalidades

- ✅ Registro e login de usuários com autenticação JWT
- ✅ Cadastro, atualização, listagem e exclusão de produtos
- ✅ Adição de produtos ao carrinho
- ✅ Criação e simulação de pedidos
- ✅ Pagamento e atualização de status de pedidos
- ✅ Histórico de status dos pedidos
- ✅ Relatório financeiro por status de pedido e período
- ✅ Swagger para documentação interativa da API

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3
- Spring Security (JWT)
- JPA (Hibernate)
- PostgreSQL (via Docker)
- Lombok
- Swagger/OpenAPI

## 🗂️ Organização do Projeto

```
src
├── application/useCases    # Casos de uso da aplicação
├── domain                  # Entidades, enums e interfaces dos repositórios
├── infra/database          # Implementações com JPA + Spring Data
├── interfaces/controller   # Camada de exposição da API (REST)
├── interfaces/dto          # Data Transfer Objects
├── config                  # Configurações de segurança e Swagger
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17+
- Docker & Docker Compose
- Maven

### Passos

1. Clone o repositório
2. Inicie o banco de dados:

```bash
docker-compose up -d
```

3. Execute o projeto:

```bash
./mvnw spring-boot:run
```

4. Acesse a documentação da API:

```
http://localhost:8080/swagger-ui/index.html
```

## 🔐 Autenticação

Utilize o endpoint `/auth/register` para criar o user. Em seguida, siga para o próximo passo.


Utilize o endpoint `/auth/login` para obter o token JWT. Em seguida, insira o token como Bearer Token no Swagger ou Postman para acessar as rotas protegidas.

---

## 📊 Exemplo de Relatório

```http
GET /report/sales?start=2024-01-01T00:00:00&end=2024-12-31T23:59:59
```

Retorna as vendas agrupadas por status (`PENDING`, `PAID`, `SHIPPED`, `DELIVERED`) com o total de cada uma.

---

## 🧑‍💻 Desenvolvedor

**José Matias**  
Desenvolvedor Back-end Java  
[LinkedIn](https://www.linkedin.com/in/jtape18/) • [GitHub](https://github.com/Jtape18)
