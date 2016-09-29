package br.com.estudo.services;


import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import br.com.estudo.controller.HibernateUtil;
import br.com.estudo.dao.CrudDAO;
import br.com.estudo.model.TaskImp;

@Service
@Named
public class TaskServiceImpl implements CrudDAO<TaskImp> {

	private Session session;

	
	@Override
	public void salvar(TaskImp entidade) throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(TaskImp entidade) throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(TaskImp entidade) throws Error {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List listar() {
		session =  HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cri = session.createCriteria(TaskImp.class);
			return cri.list();
		} finally {
			session.close();

		}
	}

	
}
