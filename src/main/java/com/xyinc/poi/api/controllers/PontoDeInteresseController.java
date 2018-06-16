package com.xyinc.poi.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.responses.Response;
import com.xyinc.poi.api.services.PontoDeInteresseService;

@RestController
@RequestMapping(path = "/api/pontoDeInteresse")
public class PontoDeInteresseController {
	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	
	@GetMapping
	public ResponseEntity<Response<List<PontoDeInteresse>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<PontoDeInteresse>>(this.pontoDeInteresseService.listarTodos()));
	}
	
	@PostMapping
	public ResponseEntity<Response<PontoDeInteresse>> cadastrar(@Valid @RequestBody PontoDeInteresse pontoDeInteresse, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<PontoDeInteresse>(erros));
		}
		return ResponseEntity.ok(new Response<PontoDeInteresse>(this.pontoDeInteresseService.cadastrar(pontoDeInteresse)));
	}
}
