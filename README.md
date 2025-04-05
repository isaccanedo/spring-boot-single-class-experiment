# 🧪 spring-boot-single-class-experiment

Este projeto é um experimento criado com o objetivo de manter **toda a lógica de uma API REST em uma única classe Java**, incluindo:

- Classe principal `@SpringBootApplication`
- Controlador REST (`@RestController`)
- Entidade JPA (`@Entity`)
- Repositório JPA (`JpaRepository`)
- Registro manual de bean (`@Bean`)
- Exceção personalizada

O propósito é **testar os limites do Spring Boot e do Spring Data JPA**, entendendo como o framework funciona internamente quando saímos do padrão convencional.

---

## 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de dados:
  - H2 (em memória) ou
  - MySQL (externo)
- Maven

---

## 🚀 Como rodar o projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/spring-boot-single-class-experiment.git
   cd spring-boot-single-class-experiment
