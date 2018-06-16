package com.xyinc.poi.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xyinc.poi.api.documents.PontoDeInteresse;

public interface PontoDeInteresseRepository extends MongoRepository<PontoDeInteresse, String> {
	
}
