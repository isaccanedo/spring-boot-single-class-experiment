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
   git clone https://github.com/isaccanedo/spring-boot-single-class-experiment.git
   cd spring-boot-single-class-experiment

   spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true


Configure o banco de dados no application.properties:

Exemplo com H2 (memória):
properties
Copiar
Editar
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
Exemplo com MySQL:
properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Rode o projeto:

bash
Copiar
Editar
./mvnw spring-boot:run
Acesse o endpoint:

bash
Copiar
Editar
GET http://localhost:8080/apiV1/funcionarios
📁 Estrutura do projeto (aninhada)
O projeto foi intencionalmente criado com tudo dentro de uma única classe:

java
Copiar
Editar
@SpringBootApplication
public class SpringBootMysqlRestApiTutorialApplication {
    // Controller
    // Repositório (interface)
    // Entidade
    // Exceção personalizada
    // Bean manual de repository
}
Isso não é uma boa prática para aplicações reais, mas é uma ótima forma de entender como o Spring Boot funciona por baixo dos panos.

⚙️ Como o Spring reconhece o Repository aninhado?
Normalmente, o Spring Data não escaneia repositórios aninhados.
Neste experimento, resolvemos isso com injeção manual via JpaRepositoryFactory:

java
Copiar
Editar
@Configuration
public static class RepositoryConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public FuncionarioRepository funcionarioRepository() {
        RepositoryFactorySupport factory = new JpaRepositoryFactory(entityManager);
        return factory.getRepository(FuncionarioRepository.class);
    }
}
📦 Endpoints disponíveis
Método	Endpoint	Descrição
GET	/apiV1/funcionarios	Lista todos os funcionários
✨ Próximos passos (ideias)
Adicionar POST, PUT, DELETE

Validação com @Valid

Documentação com Swagger

Autenticação com Spring Security

Testes automatizados com JUnit
