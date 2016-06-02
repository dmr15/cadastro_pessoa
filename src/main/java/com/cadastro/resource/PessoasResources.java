package com.cadastro.resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cadastro.adapter.PessoaAdapter;
import com.cadastro.dao.PessoaDAO;
import com.cadastro.dto.PessoaDTO;

@Path("/pessoas")
@ApplicationScoped
public class PessoasResources {
	
	@Inject 
	private PessoaDAO pessoaDAO;
	
	static private Map<Integer, PessoaDTO> map;
	
	static {
		map = new HashMap<Integer, PessoaDTO>();
		
		PessoaDTO p1 = new PessoaDTO(1, "Fulano de Tal", new Date());
		PessoaDTO p2 = new PessoaDTO(2, "Ciclano", new Date());
		PessoaDTO p3 = new PessoaDTO(3, "Silvio Santos", new Date());
		
		map.put(p1.getId(), p1);
		map.put(p2.getId(), p2);
		map.put(p3.getId(), p3);
	}
	
	@GET
	@Produces("text/xml")
	public List<PessoaDTO> listarTodos() {
		System.out.println("DAO>>>>>>>>>>>>>>>> " + pessoaDAO);
		return PessoaAdapter.toDTOList(pessoaDAO.listarTodos());
	}
	
	@Path("{id}")
	@GET
	@Produces("text/xml")
	public PessoaDTO buscarPessoaPorId(@PathParam("id") int id) {
		return map.get(id);
	}
	
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String adicionaPessoa(PessoaDTO pessoa) {
		
		if(!map.containsKey(map.size() + 1)) {
			pessoa.setId(map.size() + 1);
			map.put(pessoa.getId(), pessoa);
			return pessoa.getNome() + " adicionado.";
		}
		return "Esse id já existe";
	}
	
	@Path("{id}")
	@PUT
	@Consumes("text/xml")
	@Produces("text/plain")
	public String atualizaPessoa(PessoaDTO pessoa, @PathParam("id") int id) {
		PessoaDTO atual = map.get(id);
		atual.setNome(pessoa.getNome());
		atual.setDataNascimento(pessoa.getDataNascimento());
		return pessoa.getNome() + " atualizada.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removerPessoa(@PathParam("id") int id) {
		
		if(map.containsKey(id)) {
			map.remove(id);
			return "Pessoa removida.";
		}
		return "Pessoa não existe";
	}

}
