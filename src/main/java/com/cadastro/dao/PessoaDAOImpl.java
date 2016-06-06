package com.cadastro.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;

import com.cadastro.entity.Pessoa;
import com.cadastro.factory.BeanFactory;

@Named("pessoaDAO")
public class PessoaDAOImpl implements PessoaDAO{

	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listarTodos() {
		initEntityManager();
		return entityManager.createQuery("FROM Pessoa p").getResultList();
	}

	@Override
	public Pessoa buscarPessoaPorId(Long id) {
		initEntityManager();
		final Pessoa pessoa = (Pessoa) entityManager.find(Pessoa.class, id); 
		return pessoa;
	}

	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		initEntityManager();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();
	}

	@Override
	public void removerPessoa(Pessoa pessoa) {
		initEntityManager();
		if(pessoa.getId() != null) {
			pessoa = buscarPessoaPorId(pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) {
		
		if(pessoa.getId() != null) {
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		}
	}
	
	public void initEntityManager() {
		entityManager = BeanFactory.getEntityManager();
		entityManager.getTransaction().begin();
	}

}
