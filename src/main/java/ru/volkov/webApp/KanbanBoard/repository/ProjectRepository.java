package ru.volkov.webApp.KanbanBoard.repository;

import org.springframework.data.repository.CrudRepository;
import ru.volkov.webApp.KanbanBoard.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
