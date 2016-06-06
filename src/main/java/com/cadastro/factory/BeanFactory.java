package com.cadastro.factory;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanFactory {
	
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Object getBean(String beanName) {
		
		final Object object;
		final BeanManager beanManager = CDI.current().getBeanManager();
		final Bean bean = beanManager.getBeans(beanName).iterator().next();
		final CreationalContext ctx = beanManager.createCreationalContext(bean);
		object = beanManager.getReference(bean, bean.getBeanClass(), ctx);
		return object;
	}
	
	public static EntityManager getEntityManager() {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cadastroPessoaPersistenceUnit");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
