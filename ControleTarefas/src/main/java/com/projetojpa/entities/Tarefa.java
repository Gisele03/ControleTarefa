package com.projetojpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarefa")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank 
	private String dataFinalExecucao;
	
	@NotNull
	@NotBlank 
	private String descricaoTarefa;
	
	@NotNull
	@NotBlank 
	private String statusTarefa;

}