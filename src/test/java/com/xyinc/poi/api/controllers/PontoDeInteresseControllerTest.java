package com.xyinc.poi.api.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xyinc.poi.api.documents.Localizacao;
import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.requests.ListarPorProximidadeRequest;
import com.xyinc.poi.api.services.PontoDeInteresseService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(PontoDeInteresseController.class)
public class PontoDeInteresseControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PontoDeInteresseService pontoDeInteresseService;
	
	@Test
	public void listarTodos_quandoNaoExistemPontosDeInteresseCadastradosDeveRetornarArrayVazioStatusOK() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
		when(pontoDeInteresseService.listarTodos()).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"payload\": [], \"errors\": null}"))
				.andReturn();
	}
	
	@Test
	public void listarTodos_quandoExistemPontosDeInteresseCadastradosDeveRetornarArrayStatusOK() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
		
		PontoDeInteresse lanchonete = new PontoDeInteresse("Lanchonete", new Localizacao(27, 12));
    	PontoDeInteresse posto = new PontoDeInteresse("Posto", new Localizacao(31, 18));
    	PontoDeInteresse joalheria = new PontoDeInteresse("Joalheria", new Localizacao(15, 12));
    	
    	listaPontoDeInteresse.add(lanchonete);
    	listaPontoDeInteresse.add(posto);
    	listaPontoDeInteresse.add(joalheria);
    	
		when(pontoDeInteresseService.listarTodos()).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{ \"payload\": [{ \"nome\": \"Lanchonete\", \"localizacao\": { \"pontoX\": 27, \"pontoY\": 12 } }, { \"nome\": \"Posto\", \"localizacao\": { \"pontoX\": 31, \"pontoY\": 18 } }, { \"nome\": \"Joalheria\", \"localizacao\": { \"pontoX\": 15, \"pontoY\": 12 } } ], \"errors\": null }"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoNaoExistemPontosDeInteresseProximosDeveRetornarArrayVazioStatusOK() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse/listarPorProximidade?distanciaMaxima=20&pontoX=20&pontoY=10")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"payload\": [], \"errors\": null}"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoNaoInformarOPontoYDeveInformarBadRequest() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse/listarPorProximidade?distanciaMaxima=20&pontoX=20")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andExpect(content().json("{ \"payload\": null, \"errors\": [ \"O atributo pontoY não pode ser vazio.\" ] }"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoNaoInformarOPontoXDeveInformarBadRequest() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse/listarPorProximidade?distanciaMaxima=20&pontoY=20")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andExpect(content().json("{ \"payload\": null, \"errors\": [ \"O atributo pontoX não pode ser vazio.\" ] }"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoNaoInformarADistanciaMaximaDeveInformarBadRequest() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse/listarPorProximidade?pontoX=20&pontoY=20")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andExpect(content().json("{ \"payload\": null, \"errors\": [ \"O atributo distância máxima não pode ser vazio.\" ] }"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoNaoInformarAtributosDeveInformarBadRequest() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/pontoDeInteresse/listarPorProximidade")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andExpect(content().json("{ \"payload\": null, \"errors\": [ \"O atributo distância máxima não pode ser vazio.\", \"O atributo pontoX não pode ser vazio.\", \"O atributo pontoY não pode ser vazio.\" ] }"))
				.andReturn();
	}
	
	@Test
	public void listarPorProximidade_quandoRecebeRequisicaoPostDeveInformarMethodNotAllowed() throws Exception {
		List<PontoDeInteresse> listaPontoDeInteresse = new ArrayList<PontoDeInteresse>();
    	
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(20);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
		when(pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest)).thenReturn(listaPontoDeInteresse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/pontoDeInteresse/listarPorProximidade")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isMethodNotAllowed())
				.andReturn();
	}
	
	@Test
	public void cadastrar_quandoNaoRecebeParametrosCertosDeveInformarBadRequest() throws Exception {	
		PontoDeInteresse lanchonete = new PontoDeInteresse("Lanchonete", new Localizacao(27, 12));
    	
		when(pontoDeInteresseService.cadastrar(lanchonete)).thenReturn(lanchonete);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/pontoDeInteresse")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andReturn();
	}
}
