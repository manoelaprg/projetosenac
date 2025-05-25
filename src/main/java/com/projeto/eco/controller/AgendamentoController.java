package com.projeto.eco.controller;

import com.projeto.eco.model.Agendamento;
import com.projeto.eco.service.AgendamentoService;
import com.projeto.eco.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/agenda")
    public String listaAgenda(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());
        return "agenda";
    }

    @GetMapping("/novo-agendamento")
    public String novoAgendamento(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "novo-agendamento";
    }

    @PostMapping("/salvar")
    public String processarForm(@ModelAttribute("agendamento") Agendamento agendamento) {
        agendamentoService.salvar(agendamento);
        return "redirect:/agendamentos/agenda";  
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Agendamento agendamento = agendamentoService.buscarId(id);
        if (agendamento == null) {
            return "redirect:/agendamentos/agenda";  
        }
        model.addAttribute("agendamento", agendamento);
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "novo-agendamento";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        agendamentoService.excluir(id);
        return "redirect:/agendamentos/agenda";  
    }
}
