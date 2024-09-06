package network.webTech.labSpringMVC.repositories;

import network.webtech.labspringmvc.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para a entidade Task.
 * 
 * Esta interface é responsável por fornecer métodos para acessar e manipular dados da entidade Task
 * no banco de dados. Herda de JpaRepository, o que fornece operações CRUD básicas e consultas personalizadas.
 */
@Repository // Marca a interface como um componente de repositório no Spring
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Encontra todas as tarefas que estão marcadas como completadas.
     * 
     * @return uma lista de tarefas completadas, ordenada pela data de criação em ordem decrescente.
     */
    List<Task> findAllByCompletedIsTrueOrderByCreatedAtDesc();

    /**
     * Encontra todas as tarefas que não estão marcadas como completadas.
     * 
     * @return uma lista de tarefas não completadas, ordenada pela data de criação em ordem decrescente.
     */
    List<Task> findAllByCompletedIsFalseOrderByCreatedAtDesc();
}