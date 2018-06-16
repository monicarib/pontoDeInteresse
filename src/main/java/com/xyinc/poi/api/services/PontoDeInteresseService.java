package com.xyinc.poi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.repositories.PontoDeInteresseRepository;

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
	public List<PontoDeInteresse> listarPorProximidade(String pontoX, String pontoY) {
		// TODO Auto-generated method stub
		return null;
	}

}
