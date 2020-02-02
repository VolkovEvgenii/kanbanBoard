package ru.volkov.webApp.KanbanBoard.repository;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.volkov.webApp.KanbanBoard.entity.ProjectStage;
import ru.volkov.webApp.KanbanBoard.entity.Task;
import ru.volkov.webApp.KanbanBoard.entity.Project;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findTaskByProjectIdAndStage(Integer projectId, ProjectStage projectStage);

    @Query("SELECT DISTINCT t FROM Task t JOIN t.project p WHERE p.id =:projectId AND t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.CONTRACT")
    List<Task> taskByContract(@Param("projectId") Integer projectId);

    @Query("SELECT t FROM Task AS t WHERE t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.AGREEMENT")
    List<Task> taskByAgreement();

    @Query("SELECT t FROM Task AS t WHERE t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.ROUTING")
    List<Task> taskByRouting();

    @Query("SELECT t FROM Task AS t WHERE t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.WORK")
    List<Task> taskByWork();

    @Query("SELECT t FROM Task AS t WHERE t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.DOCUMENTATION")
    List<Task> taskByDocumentation();

    @Query("SELECT t FROM Task AS t WHERE t.stage = ru.volkov.webApp.KanbanBoard.entity.ProjectStage.MOB_DEMOB")
    List<Task> taskByMob_Demob();
}
