package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Tarefa;
import com.projetojpa.repository.TarefaRepository;

@Service 
public class TarefaService { 
	private final TarefaRepository tarefaRepository; 

	@Autowired 
	public TarefaService(TarefaRepository tarefaRepository) { 
        this.tarefaRepository = tarefaRepository; 
    } 

	public List<Tarefa> buscaTodosTarefas(){ 
		return tarefaRepository.findAll(); 
	} 
	
    public Tarefa buscaTarefaById(Long id) { 
    	Optional <Tarefa> tarefa = tarefaRepository.findById(id); 
        return tarefa.orElse(null); 
    } 

    public Tarefa salvaTarefa(Tarefa tarefa) { 
        return tarefaRepository.save(tarefa); 
    } 

    public Tarefa alterarTarefa(Long id, Tarefa alterarTarefa) { 
    	Optional <Tarefa> existeTarefa = tarefaRepository.findById(id); 
    	if(existeTarefa.isPresent()) { 
    		alterarTarefa.setId(id); 
    		return tarefaRepository.save(alterarTarefa); 
    	} 
    	return null; 
    } 
    public boolean apagarTarefa(Long id) { 
    	Optional <Tarefa> existeTarefa = tarefaRepository.findById(id); 
    	if(existeTarefa.isPresent()) { 
    		tarefaRepository.deleteById(id); 
    		return true; 
    	} 
    	return false; 
    } 

}