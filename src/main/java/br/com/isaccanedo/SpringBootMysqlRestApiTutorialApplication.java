package br.com.isaccanedo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.sql.DataSource;
import javax.validation.constraints.NotBlank;
import java.util.List;

@SpringBootApplication
public class SpringBootMysqlRestApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlRestApiTutorialApplication.class, args);
	}

	// ========================== ENTIDADE ==========================
	@Entity
	@Table(name = "funcionarios")
	public static class FuncionarioModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank
		private String nome;

		@NotBlank
		private String cargo;

		// Getters e Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
	}

	// ========================== REPOSITÓRIO ==========================
	public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
	}

	// ========================== CONFIGURAÇÃO MANUAL ==========================
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

	// ========================== CONTROLLER ==========================
	@RestController
	@RequestMapping("/apiV1")
	public static class FuncionariosController {

		private final FuncionarioRepository funcionarioRepository;

		@Autowired
		public FuncionariosController(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;
		}

		@GetMapping("/funcionarios")
		public List<FuncionarioModel> getFuncionarios() {
			return funcionarioRepository.findAll();
		}
	}

	// ========================== EXCEÇÃO ==========================
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public static class ResourceNotFoundException extends RuntimeException {

		public ResourceNotFoundException(String resource, String field, Object value) {
			super(String.format("%s not found with %s: '%s'", resource, field, value));
		}
	}
}