package network.webTech.labSpringMVC.models;
      
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

      
/**
 * Representa uma tarefa no sistema.
 */
@Entity
@Table(name = "tb_task") // Define o nome da tabela no banco de dados
@Builder // Adiciona o padrão de construção para a entidade
@Data // Gera getters, setters, equals, hashCode e toString
@AllArgsConstructor // Gera um construtor com todos os campos
@NoArgsConstructor // Gera um construtor sem parâmetros
public class Task {

    @Id // Define o campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente
    private Long id;
               
    @NotNull // Garante que o título não seja nulo
    @Size(min = 1, max = 30) // Define o tamanho mínimo e máximo do título
    private String title;
               
    @NotNull // Garante que a descrição não seja nula
    @Size(min = 5, max = 80) // Define o tamanho mínimo e máximo da descrição
    private String description;
               
    @Builder.Default // Define o valor padrão para completed
    private boolean completed = false;
               
    @CreationTimestamp // Adiciona a data de criação automaticamente
    private Date createdAt;
               
    @UpdateTimestamp // Atualiza a data sempre que a entidade for modificada
    private Date updatedAt;
}