package ru.volkov.webApp.KanbanBoard.repository;

import org.springframework.data.repository.CrudRepository;
import ru.volkov.webApp.KanbanBoard.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
