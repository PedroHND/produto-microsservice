package com.delivery.produto;

import com.delivery.produto.model.ProductModel;
import com.delivery.produto.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Autowired
	private IProductRepository productRepository;


	@Override
	public void run(String... args) throws Exception {

	}
}
