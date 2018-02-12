package br.edu.cse.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Cidade;

@RestController
public class CidadesRestController {

	@GetMapping("/cidades")
	public Collection<Cidade> obtemCidades() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:4040");
		Collection<Cidade> lista = new ArrayList<>();
		lista = (Collection<Cidade>)target.path("/cidades").request().get();
		return lista;
	}

}
