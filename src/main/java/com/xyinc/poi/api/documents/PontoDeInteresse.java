package com.xyinc.poi.api.documents;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PontoDeInteresse {
	@Id
	private String id;
	private String nome;
	private Integer pontoX;
	private Integer pontoY;
	
	public PontoDeInteresse() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message = "O atributo nome não pode ser vazio.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull(message = "O atributo pontoX não pode ser vazio.")
	@Min(value = 0, message = "O atributo pontoX deve ser um inteiro positivo.")
	public Integer getPontoX() {
		return pontoX;
	}

	public void setPontoX(Integer pontoX) {
		this.pontoX = pontoX;
	}
	
	@NotNull(message = "O atributo pontoY não pode ser vazio.")
	@Min(value = 0, message = "O atributo pontoY deve ser um inteiro positivo.")
	public Integer getPontoY() {
		return pontoY;
	}

	public void setPontoY(Integer pontoY) {
		this.pontoY = pontoY;
	}
}
