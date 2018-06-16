package com.xyinc.poi.api.services;

import java.util.List;

import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.requests.ListarPorProximidadeRequest;

public interface IPontoDeInteresseService {
	PontoDeInteresse cadastrar(PontoDeInteresse pontoDeInteresse);
	List<PontoDeInteresse> listarTodos();
	List<PontoDeInteresse> listarPorProximidade(ListarPorProximidadeRequest listarPorProximidadeRequest);
}
