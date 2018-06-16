package com.xyinc.poi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.repositories.PontoDeInteresseRepository;
import com.xyinc.poi.api.requests.ListarPorProximidadeRequest;

@Service
public class PontoDeInteresseService implements IPontoDeInteresseService {
	
	@Autowired
	private PontoDeInteresseRepository pontoDeInteresseRepository;
	
	@Override
	public PontoDeInteresse cadastrar(PontoDeInteresse pontoDeInteresse) {
		return this.pontoDeInteresseRepository.save(pontoDeInteresse);
	}

	@Override
	public List<PontoDeInteresse> listarTodos() {
		return this.pontoDeInteresseRepository.findAll();
	}

	@Override
	public List<PontoDeInteresse> listarPorProximidade(ListarPorProximidadeRequest listarPorProximidadeRequest) {
		Point ponto = new Point(listarPorProximidadeRequest.getPontoX(), listarPorProximidadeRequest.getPontoY());
		Distance distancia = new Distance(listarPorProximidadeRequest.getDistanciaMaxima());
		return this.pontoDeInteresseRepository.findByLocalizacaoNear(ponto, distancia);
	}
}
