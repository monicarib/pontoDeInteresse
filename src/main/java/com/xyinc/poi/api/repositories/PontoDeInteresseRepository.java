package com.xyinc.poi.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Distance;
import com.xyinc.poi.api.documents.PontoDeInteresse;

public interface PontoDeInteresseRepository extends MongoRepository<PontoDeInteresse, String> {
	public List<PontoDeInteresse> findByLocalizacaoNear(org.springframework.data.geo.Point ponto, Distance distance);
}