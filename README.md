#  Spring Boot - Bean Validation + JPA + H2

##  Sobre o Projeto

Este projeto é um exemplo simples de API REST desenvolvida com **Spring Boot**, com foco em:

* ✅ Bean Validation (`@Valid`)
* ✅ DTO Pattern
* ✅ Tratamento global de exceções
* ✅ Persistência com Spring Data JPA
* ✅ Banco de dados H2 em memória

O objetivo é demonstrar como validar dados de entrada em um endpoint REST e retornar mensagens de erro personalizadas.

---

##  Tecnologias Utilizadas

* Java 21+
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation (Jakarta Validation)
* H2 Database

---

## 📂 Estrutura do Projeto

```
controller → Camada de entrada (API REST)
service    → Regras de negócio
repository → Acesso ao banco
model      → Entidade JPA
DTO        → Objeto de transferência com validação
exception  → Tratamento global de erros
```

---

##  Funcionalidade Implementada

### 🔹 Endpoint

```
POST /api/users
```

Recebe um `UserRegistrationDTO` com as seguintes validações:

| Campo    | Validações                      |
| -------- | ------------------------------- |
| username | @NotBlank, @Size(min=5, max=20) |
| email    | @NotBlank, @Email               |
| password | @NotBlank, @Size(min=8)         |
| age      | @NotNull, @Min(18)              |

---

##  Como Executar

1. Clonar o repositório
2. Executar a aplicação
3. Acessar:

```
http://localhost:8080
```

---

##  Banco H2

Console disponível em:

```
http://localhost:8080/h2-console
```

Configuração JDBC:

```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (em branco)
```

---

##  Como Testar

### ✅ Requisição válida

POST `/api/users`

```json
{
  "username": "ezequiel",
  "email": "ezequiel@email.com",
  "password": "12345678",
  "age": 25
}
```

Retorno: `200 OK` com usuário salvo.

---

### ❌ Requisição inválida

```json
{
  "username": "ez",
  "email": "emailerrado",
  "password": "123",
  "age": 15
}
```

Retorno: `400 Bad Request`

```json
{
  "username": "O tamanho deve ser entre 5 e 20 caracteres.",
  "email": "O campo deve conter um endereço de e-mail válido.",
  "password": "Tamanho mínimo de 8 caracteres.",
  "age": "A idade mínima é 18 anos."
}
```

---

## Objetivo de Aprendizado

* Entender como o `@Valid` dispara validações automáticas
* Compreender o fluxo de exceções no Spring
* Implementar `@RestControllerAdvice` para respostas personalizadas
* Separar DTO de Entity seguindo boas práticas

---



Projeto criado para estudo de validação e arquitetura REST com Spring Boot.
