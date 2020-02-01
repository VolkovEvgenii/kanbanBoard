package ru.volkov.webApp.KanbanBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.volkov.webApp.KanbanBoard.entity.*;
import ru.volkov.webApp.KanbanBoard.repository.KanbanUserRepository;
import ru.volkov.webApp.KanbanBoard.repository.ProjectRepository;
import ru.volkov.webApp.KanbanBoard.repository.TaskRepository;

@Controller
public class TaskController {
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;
    private KanbanUserRepository kanbanUserRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository, KanbanUserRepository kanbanUserRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.kanbanUserRepository = kanbanUserRepository;
    }

    @GetMapping(value = "/task/add")
    public String showForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("kanbanUsers", kanbanUserRepository.findAll());
        model.addAttribute("projectStages", ProjectStage.values());
        model.addAttribute("taskImportances", TaskImportance.values());
        return "addTask";
    }

    @PostMapping(value = "/task/add")
    public String submitForm(@ModelAttribute Task task,
                             @RequestParam(name = "projectId") int projectId,
                             @RequestParam(name = "kanbanUserId") int kanbanUserId) {
        Project project = projectRepository.findById(projectId).get();
        KanbanUser kanbanUser = kanbanUserRepository.findById(kanbanUserId).get();
        task.setProject(project);
        task.setKanbanUser(kanbanUser);
        project.getTaskList().add(task);
        kanbanUser.getTaskList().add(task);

        taskRepository.save(task);
        return ("redirect:/task/add");
    }
}
