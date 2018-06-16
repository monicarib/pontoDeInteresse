package com.xyinc.poi.api.services;

import java.util.List;

import com.xyinc.poi.api.documents.PontoDeInteresse;

public interface PontoDeInteresseService {
	PontoDeInteresse cadastrar();
	List<PontoDeInteresse> listarTodos();
	List<PontoDeInteresse> listarPorProximidade(String pontoX, String pontoY);
}
