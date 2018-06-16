package com.xyinc.poi.api.documents;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontoX() {
		return pontoX;
	}

	public void setPontoX(Integer pontoX) {
		this.pontoX = pontoX;
	}

	public Integer getPontoY() {
		return pontoY;
	}

	public void setPontoY(Integer pontoY) {
		this.pontoY = pontoY;
	}
}
