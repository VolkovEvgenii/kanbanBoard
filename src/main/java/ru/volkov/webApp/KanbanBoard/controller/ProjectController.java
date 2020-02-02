package ru.volkov.webApp.KanbanBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volkov.webApp.KanbanBoard.entity.Project;
import ru.volkov.webApp.KanbanBoard.repository.ProjectRepository;

@Controller
public class ProjectController {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping(value = "/project/add")
    public String showForm(Model model) {
        model.addAttribute("project", new Project());
        return "addProject";
    }

    @PostMapping(value = "/project/add")
    public String submitForm (@ModelAttribute Project project) {
        projectRepository.save(project);
        return "redirect:/project/add";
    }
}
