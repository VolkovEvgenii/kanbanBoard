package ru.volkov.webApp.KanbanBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.volkov.webApp.KanbanBoard.entity.KanbanUser;
import ru.volkov.webApp.KanbanBoard.repository.KanbanUserRepository;

@Controller
public class KanbanUserController {
    private KanbanUserRepository kanbanUserRepository;

    @Autowired
    public KanbanUserController(KanbanUserRepository kanbanUserRepository) {
        this.kanbanUserRepository = kanbanUserRepository;
    }

    @GetMapping(value = "/kanbanUser/add")
    public String showForm(Model model) {
        model.addAttribute("kanbanUser", new KanbanUser());
        return "addKanbanUser";
    }

    @PostMapping(value = "/kanbanUser/add")
    public String submitForm (@ModelAttribute KanbanUser kanbanUser) {
        kanbanUserRepository.save(kanbanUser);
        return ("redirect:/kanbanUser/add");
    }
}
