package com.jean.cursoudemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jean.cursoudemy.domain.Categoria;
import com.jean.cursoudemy.domain.Cidade;
import com.jean.cursoudemy.domain.Estado;
import com.jean.cursoudemy.domain.Produto;
import com.jean.cursoudemy.repository.CategoriaRepository;
import com.jean.cursoudemy.repository.CidadeRepository;
import com.jean.cursoudemy.repository.EstadoRepository;
import com.jean.cursoudemy.repository.ProdutoRepository;

@SpringBootApplication
public class CursoudemyApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtorepository;
	@Autowired
	private EstadoRepository estadorepository;
	@Autowired
	private CidadeRepository cidaderepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		
	
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriarepository.saveAll(Arrays.asList(cat1,cat2));
		produtorepository.saveAll(Arrays.asList(p1,p2,p3));
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		
		
		estadorepository.saveAll(Arrays.asList(est1,est2));
		cidaderepository.saveAll(Arrays.asList(c1,c2,c3));
	
	}

}
