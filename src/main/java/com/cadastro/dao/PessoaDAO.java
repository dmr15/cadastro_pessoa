package com.cadastro.dao;

import java.util.List;

import com.cadastro.entity.Pessoa;

public interface PessoaDAO {
	
public List<Pessoa> listarTodos();
	
	public Pessoa buscarPessoaPorId(Long id);
	
	public void adicionarPessoa(Pessoa pessoa);
	
	public void removerPessoa(Pessoa pessoa);
	
	public void atualizarPessoa(Pessoa pessoa);

}
