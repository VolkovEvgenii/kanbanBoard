package ru.volkov.webApp.KanbanBoard.repository;

import org.springframework.data.repository.CrudRepository;
import ru.volkov.webApp.KanbanBoard.entity.KanbanUser;

public interface KanbanUserRepository extends CrudRepository<KanbanUser, Integer> {
}
