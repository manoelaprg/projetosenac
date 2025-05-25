
package com.projeto.eco.service;

import com.projeto.eco.model.Paciente;
import com.projeto.eco.repository.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
     @Autowired
    private PacienteRepository pacienteRepository;
    
    public void salvar(Paciente p){
        pacienteRepository.save(p);
    }
    
    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }
    
    public Paciente buscarId(int id){
        return pacienteRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id){
        pacienteRepository.deleteById(id);
    }
}