package com.jean.cursoudemy;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jean.cursoudemy.domain.Categoria;
import com.jean.cursoudemy.domain.Cidade;
import com.jean.cursoudemy.domain.Cliente;
import com.jean.cursoudemy.domain.Endereco;
import com.jean.cursoudemy.domain.Estado;
import com.jean.cursoudemy.domain.Pagamento;
import com.jean.cursoudemy.domain.PagamentoComBoleto;
import com.jean.cursoudemy.domain.PagamentoComCartao;
import com.jean.cursoudemy.domain.Pedido;
import com.jean.cursoudemy.domain.Produto;
import com.jean.cursoudemy.domain.enums.EstadoPagamento;
import com.jean.cursoudemy.domain.enums.TipoCliente;
import com.jean.cursoudemy.repository.CategoriaRepository;
import com.jean.cursoudemy.repository.CidadeRepository;
import com.jean.cursoudemy.repository.ClienteRepository;
import com.jean.cursoudemy.repository.EnderecoRepository;
import com.jean.cursoudemy.repository.EstadoRepository;
import com.jean.cursoudemy.repository.PagamentoRepository;
import com.jean.cursoudemy.repository.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired 
	EnderecoRepository enderecorepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
	
	
	
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
	

		Cliente cli1 = new Cliente(null, "jean", "jean.jr.souza","045050505", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("75404701", "458501405"));
		
		Endereco e1 = new Endereco(null, "Rua Marechal", "138", "casa", "Centro", "44500000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua de cina", "138", "casa", "Centro", "44500333", cli1, c2);
	
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
	
		clienterepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("13/05/2020 14:25"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("13/05/2020 14:30"), cli1, e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("30/05/2020 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		
	}

}
