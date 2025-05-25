
package com.projeto.eco.service;

import com.projeto.eco.model.Agendamento;
import com.projeto.eco.repository.AgendamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void salvar (Agendamento a) {
        agendamentoRepository.save(a);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarId(int id) {
        return agendamentoRepository.findById(id).orElse(null);
    }

    public void excluir(int id) {
        agendamentoRepository.deleteById(id);
    }
}
