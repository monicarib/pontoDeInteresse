package com.xyinc.poi.api.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ListarPorProximidadeRequest {
	private Integer distanciaMaxima;
	private Integer pontoX;
	private Integer pontoY;
	
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
	
	@NotNull(message = "O atributo distância máxima não pode ser vazio.")
	@Min(value = 0, message = "O atributo distância máxima deve ser um inteiro positivo.")
	public Integer getDistanciaMaxima() {
		return distanciaMaxima;
	}
	
	public void setDistanciaMaxima(Integer distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}
}
