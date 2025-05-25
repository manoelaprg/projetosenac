/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.eco.controller;

import com.projeto.eco.model.Paciente;
import com.projeto.eco.service.AgendamentoService;
import com.projeto.eco.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/paciente-cadastro")
    public String formularioCadastro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente-cadastro";  
    }

    
 @PostMapping("/salvar")
public String salvarPaciente(@ModelAttribute Paciente p) {
    pacienteService.salvar(p);
    return "redirect:/paciente/lista"; 
}


    @GetMapping("/lista")
    public String listaPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "/paciente-lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterarPaciente(@PathVariable int id, Model model) {
        model.addAttribute("paciente", pacienteService.buscarId(id));
        return "/paciente-cadastro"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable int id) {
        pacienteService.excluir(id);
        return "redirect:/paciente/lista";  
    }
}
