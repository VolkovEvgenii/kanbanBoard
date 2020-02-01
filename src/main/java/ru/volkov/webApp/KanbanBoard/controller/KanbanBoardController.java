package ru.volkov.webApp.KanbanBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.volkov.webApp.KanbanBoard.entity.Project;
import ru.volkov.webApp.KanbanBoard.entity.ProjectStage;
import ru.volkov.webApp.KanbanBoard.repository.KanbanBoardRepository;
import ru.volkov.webApp.KanbanBoard.repository.KanbanUserRepository;
import ru.volkov.webApp.KanbanBoard.repository.ProjectRepository;
import ru.volkov.webApp.KanbanBoard.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KanbanBoardController {
    private KanbanBoardRepository kanbanBoardRepository;
    private ProjectRepository projectRepository;
    private KanbanUserRepository kanbanUserRepository;
    private TaskRepository taskRepository;

    private List<Project> projectList = new ArrayList<>();

    @Autowired
    public KanbanBoardController(KanbanBoardRepository kanbanBoardRepository,
                                 ProjectRepository projectRepository,
                                 KanbanUserRepository kanbanUserRepository,
                                 TaskRepository taskRepository) {
        this.kanbanBoardRepository = kanbanBoardRepository;
        this.projectRepository = projectRepository;
        this.kanbanUserRepository = kanbanUserRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/refreshCombo")
    public String showForm (ModelMap modelMap) {
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/showAllTask")
    public String showAllTask (
            Model model,
            @RequestParam(name = "projectId", required = false) Integer projectId)
    {
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("tasksByContract", taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.CONTRACT));
        model.addAttribute("tasksByAgreement",taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.AGREEMENT));
        model.addAttribute("tasksByRouting",taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.ROUTING));
        model.addAttribute("tasksByWork",taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.WORK));
        model.addAttribute("tasksByDocumentation",taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.DOCUMENTATION));
        model.addAttribute("tasksByMob_Demob",taskRepository.findTaskByProjectIdAndStage(projectId, ProjectStage.MOB_DEMOB));
        return "index";
    }




}
