package br.com.estudo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import br.com.estudo.controller.HibernateUtil;
import br.com.estudo.model.TaskImp;

@Repository
public class TaskDAO implements CrudDAO<TaskImp> {

	private Session session;

	@Override
	public void salvar(TaskImp taskImp) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(taskImp);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

	@Override
	public void deletar(TaskImp taskImp) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(taskImp);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
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

	@Override
	public void editar(TaskImp taskImp) throws Error {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(taskImp);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

}
