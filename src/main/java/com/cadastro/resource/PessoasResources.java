package com.cadastro.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.cadastro.entity.Pessoa;

@Path("/pessoas")
public class PessoasResources {
	
	static private Map<Integer, Pessoa> map;
	
	static {
		map = new HashMap<Integer, Pessoa>();
		
		Pessoa p1 = new Pessoa(1, "Fulano de Tal", new Date());
		Pessoa p2 = new Pessoa(2, "Ciclano", new Date());
		Pessoa p3 = new Pessoa(3, "Silvio Santos", new Date());
		
		map.put(p1.getId(), p1);
		map.put(p2.getId(), p2);
		map.put(p3.getId(), p3);
	}
	
	@GET
	@Produces("text/xml")
	public List<Pessoa> getPessoas() {
		return new ArrayList<Pessoa>(map.values());
	}

}
