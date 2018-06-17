package com.xyinc.poi.api.documents;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PontoDeInteresse {
	@Id
	private String id;
	private String nome;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2D)
	private Localizacao localizacao;
	
	public PontoDeInteresse() {
		
	}

	public PontoDeInteresse(String nome, Localizacao localizacao) {
		this.nome = nome;
		this.localizacao = localizacao;
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

	@Valid
	@NotNull (message = "A localização não pode ser vazia.")
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
}
