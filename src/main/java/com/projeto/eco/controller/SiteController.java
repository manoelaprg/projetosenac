package com.projeto.eco.controller;

import com.projeto.eco.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/")
    public String Inicio(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());
        return "index";
    }

    @GetMapping("/paciente-cadastro")
    public String novoPaciente() {
        return "paciente-cadastro";
    }

    @GetMapping("/novo-agendamento")
    public String novoAgendamento() {
        return "novo-agendamento";
    }

    @GetMapping("/agenda")
    public String agenda() {
        return "agenda";
    }

    @GetMapping("/paciente-lista")
    public String pacienteLista() {
        return "paciente-lista";
    }
}
