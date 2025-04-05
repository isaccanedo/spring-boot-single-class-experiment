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
- H2 (em memória)
- Maven

---

## 🚀 Como rodar o projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/isaccanedo/spring-boot-single-class-experiment.git
   cd spring-boot-single-class-experiment
   ```
  
## Configure o banco de dados no application.properties:
```
Exemplo com H2 (memória):

# Configuração do banco de dados H2 em memória
spring.datasource.url=jdbc:h2:mem:bancoMemoria
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuração do Hibernate para H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# Configuração para console H2 (opcional)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
Rode o projeto:
```
./mvnw spring-boot:run
```

### Acesse o endpoint:

```
GET http://localhost:8080/apiV1/funcionarios
```

# 📁 Estrutura do projeto (aninhada)
**O projeto foi intencionalmente criado com tudo dentro de uma única classe:**

@SpringBootApplication
public class SpringBootMysqlRestApiTutorialApplication {
    // Controller
    // Repositório (interface)
    // Entidade
    // Exceção personalizada
    // Bean manual de repository
}

**OBSERVAÇÃO**
```
Isso não é uma boa prática para aplicações reais, mas é uma ótima forma de entender como o Spring Boot funciona por baixo dos panos.
```

### ⚙️ Como o Spring reconhece o Repository aninhado?
Normalmente, o Spring Data não escaneia repositórios aninhados.
Neste experimento, resolvemos isso com injeção manual via JpaRepositoryFactory:

```
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
```
