package com.cadastro.service;

import com.cadastro.entity.Pessoa;

public interface PessoaService {

	public Pessoa buscarPessoaPorId(Long id);

	public void adicionarPessoa(Pessoa pessoa);

	public void removerPessoa(Pessoa pessoa);

	public void atualizarPessoa(Pessoa pessoa);

}
