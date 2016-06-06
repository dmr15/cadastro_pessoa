package com.cadastro.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
import com.cadastro.entity.Pessoa;
import com.cadastro.factory.BeanFactory;

@Path("/pessoas")
@RequestScoped
public class PessoasResources {
	
	private PessoaDAO pessoaDAO;
	
	@PostConstruct
	public void init() {
		pessoaDAO = (PessoaDAO) BeanFactory.getBean("pessoaDAO");
	}
	
	@GET
	@Produces("text/xml")
	public List<PessoaDTO> listarTodos() {
		return PessoaAdapter.toDTOList(pessoaDAO.listarTodos());
	}
	
	@Path("{id}")
	@GET
	@Produces("text/xml")
	public PessoaDTO buscarPessoaPorId(@PathParam("id") int id) {
		return PessoaAdapter.toDTO(pessoaDAO.buscarPessoaPorId(new Long(id)));
	}
	
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String adicionaPessoa(PessoaDTO pessoaDTO) {
		pessoaDAO.adicionarPessoa(PessoaAdapter.toPessoa(pessoaDTO));
		return "Pessoa adicionada!";
		
	}
	
	@Path("{id}")
	@PUT
	@Consumes("text/xml")
	@Produces("text/plain")
	public String atualizaPessoa(PessoaDTO pessoaDTO, @PathParam("id") int id) {
		
		Pessoa pessoa = pessoaDAO.buscarPessoaPorId(new Long(id));
		pessoa = PessoaAdapter.toPessoa(pessoaDTO);
		pessoaDAO.atualizarPessoa(pessoa);
		
		return pessoa.getNome() + " atualizada.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removerPessoa(@PathParam("id") int id) {
		
		Pessoa pessoa = pessoaDAO.buscarPessoaPorId(new Long(id));
		pessoaDAO.removerPessoa(pessoa);
		return "Pessoa removida com sucesso!";
	}

}
