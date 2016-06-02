package com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cadastro.entity.Pessoa;

public class PessoaDAOImpl implements PessoaDAO{

	@PersistenceContext(unitName = "cadastroPessoaPersistenceUnit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listarTodos() {
		System.out.println("EM>>>>>>>>>>>>>>>> " + entityManager);
		entityManager.getTransaction().begin();
		return entityManager.createQuery("FROM Pessoa p").getResultList();
	}

	@Override
	public Pessoa buscarPessoaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

}
