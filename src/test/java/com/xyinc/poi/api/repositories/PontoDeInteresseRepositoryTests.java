package com.xyinc.poi.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.xyinc.poi.api.documents.Localizacao;
import com.xyinc.poi.api.documents.PontoDeInteresse;
import com.xyinc.poi.api.requests.ListarPorProximidadeRequest;
import com.xyinc.poi.api.services.PontoDeInteresseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PontoDeInteresseRepositoryTests {
	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	
    @Before
    public void setUp() throws Exception {
    	inserirPontosDeInteresse();
    }

    @After
    public void tearDown() throws Exception {
    	deletarTodosPontosDeInteresse();
    }
    
    @Test
    public void findByLocalizacaoNear() {
    	ListarPorProximidadeRequest listarPorProximidadeRequest = new ListarPorProximidadeRequest();
    	listarPorProximidadeRequest.setDistanciaMaxima(10);
    	listarPorProximidadeRequest.setPontoX(20);
    	listarPorProximidadeRequest.setPontoY(10);
    	
    	List<PontoDeInteresse> pontosDeInteresseProximos = this.pontoDeInteresseService.listarPorProximidade(listarPorProximidadeRequest);
        assertEquals(4, pontosDeInteresseProximos.size());
        
        List<String> nomesnomesPontosDeInteresseExpected = Arrays.asList("Supermercado", "Joalheria", "Lanchonete", "Pub");
        List<String> nomesPontosDeInteresse = new ArrayList<String>();        
        pontosDeInteresseProximos.forEach(pontoDeInteresse -> nomesPontosDeInteresse.add(pontoDeInteresse.getNome()));
        assertEquals(nomesnomesPontosDeInteresseExpected, nomesPontosDeInteresse);        
    }
    
    public void inserirPontosDeInteresse() {
    	PontoDeInteresse lanchonete = new PontoDeInteresse("Lanchonete", new Localizacao(27, 12));
    	PontoDeInteresse posto = new PontoDeInteresse("Posto", new Localizacao(31, 18));
    	PontoDeInteresse joalheria = new PontoDeInteresse("Joalheria", new Localizacao(15, 12));
    	PontoDeInteresse floricultura = new PontoDeInteresse("Floricultura", new Localizacao(19, 21));
    	PontoDeInteresse pub = new PontoDeInteresse("Pub", new Localizacao(12, 8));
    	PontoDeInteresse supermercado = new PontoDeInteresse("Supermercado", new Localizacao(23, 6));
    	PontoDeInteresse churrascaria = new PontoDeInteresse("Churrascaria", new Localizacao(28, 2));
    	
    	this.pontoDeInteresseService.cadastrar(lanchonete);
    	this.pontoDeInteresseService.cadastrar(posto);
    	this.pontoDeInteresseService.cadastrar(joalheria);
    	this.pontoDeInteresseService.cadastrar(floricultura);
    	this.pontoDeInteresseService.cadastrar(supermercado);
    	this.pontoDeInteresseService.cadastrar(pub);
    	this.pontoDeInteresseService.cadastrar(churrascaria);
    	
    	List<PontoDeInteresse> pontosCadastrados = this.pontoDeInteresseService.listarTodos();
    	assertEquals(7, pontosCadastrados.size());
    }
    
    public void deletarTodosPontosDeInteresse() {
    	this.pontoDeInteresseService.deletarTodos();
    	List<PontoDeInteresse> pontosCadastrados = this.pontoDeInteresseService.listarTodos();
    	assertEquals(0, pontosCadastrados.size());
    }
}
