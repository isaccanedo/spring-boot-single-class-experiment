# Spring Boot REST API com o Banco de Dados em Memória H2

Este é um projeto **Spring Boot REST API** para gerenciamento de **funcionários**, utilizando um banco de dados **H2 em memória**. Ele permite criar, listar, atualizar e excluir funcionários através de endpoints REST.

## 📌 Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Banco de dados H2 (em memória)**
- **Maven**

## 🚀 Configuração do Banco de Dados H2 em Memória

O projeto utiliza um banco de dados **H2** em memória, sendo criado automaticamente ao iniciar a aplicação.

### 📄 Configuração no `application.properties`:
```properties
# Banco de dados H2
spring.datasource.url=jdbc:h2:mem:bancoMemoria
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuração do Hibernate para H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# Habilitar console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
Acesse o console H2 em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 🔧 Como Rodar o Projeto

### 1️⃣ Clonar o repositório
```sh
git clone https://github.com/isaccanedo/spring-boot-h2-rest-api.git
cd seu-repositorio
```

### 2️⃣ Compilar o projeto
```sh
mvn clean install
```

### 3️⃣ Executar a aplicação
```sh
mvn spring-boot:run
```

A API estará disponível em: [http://localhost:8080/api](http://localhost:8080/api)

## 📡 Endpoints da API

### 🔍 Listar todos os funcionários
```http
GET /apiV1/funcionarios
```

### ➕ Criar um novo funcionário
```http
POST /apiV1/funcionario/novo
Content-Type: application/json

{
  "nome": "ISAC CANEDO",
  "cargo": "ENGENHEIRO DE SOFTWARE"
}
```

### 🔎 Buscar funcionário por ID
```http
GET /apiV1/funcionario/{id}
```

### ✏️ Atualizar um funcionário
```http
PUT /apiV1/funcionario/{id}
Content-Type: application/json

{
  "nome": "ISAC CANEDO",
  "cargo": "ESPECIALISTA EM ENGENHARIA DE SOFTWARE"
}
```

### ❌ Deletar um funcionário
```http
DELETE /apiV1/funcionario/{id}
```

## 🛠 Estrutura do Projeto
```
├── src
│   ├── main
│   │   ├── java/br/com/isaccanedo
│   │   │   ├── controller
│   │   │   │   ├── FuncionariosController.java
│   │   │   ├── model
│   │   │   │   ├── FuncionarioModel.java
│   │   │   ├── repository
│   │   │   │   ├── FuncionarioRepository.java
│   │   │   ├── exception
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   ├── SpringBootH2Application.java
│   ├── resources
│   │   ├── application.properties
│   ├── test
├── pom.xml
└── README.md
```
✅ **Este projeto passou nos testes automatizados utilizando o GitHub Actions**

✅ **Projeto com Integração Contínua:**
Isso significa que, a cada commit ou pull request enviado para o repositório, o GitHub automaticamente executa o workflow definido com os testes automatizados.

✅ **Projeto com Automação de Build e Testes:**
O processo de build (compilação) e testes está automatizado, sendo executado sempre que há uma mudança no código.
