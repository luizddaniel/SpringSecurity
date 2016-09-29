package br.com.estudo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.estudo.controller.HibernateUtil;
import br.com.estudo.model.UserImp;

public class UserDAO implements CrudDAO<UserImp> {

	private Session session;

	@Override
	public void salvar(UserImp userImp) throws Error {

		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(userImp);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

	@Override
	public void deletar(UserImp userImp) throws Error {

		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(userImp);
			session.getTransaction().commit();

		} finally {
			session.close();

		}

	}

	@Override
	public void editar(UserImp userImp) throws Error {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(userImp);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserImp> listar() throws Error {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cri = session.createCriteria(UserImp.class);
			return cri.list();
		} finally {
			session.close();

		}
	}

	@SuppressWarnings("unchecked")
	public UserImp findByUserName(String username) {
		session = HibernateUtil.getSessionFactory().openSession();

		List<UserImp> users = new ArrayList<UserImp>();
		UserImp userImp = new UserImp();

		Criteria cri = session.createCriteria(UserImp.class);
		users = cri.list();

		for (UserImp user : users) {
			if (username.equals(user.getLogin())) {
				userImp = user;
			} else {
				userImp.setLogin("adm");
				userImp.setPassword("adm");
			}
		}
		return userImp;
	}
}
