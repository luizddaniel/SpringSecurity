package br.com.estudo.teste;



import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import br.com.estudo.controller.HibernateUtil;
import br.com.estudo.model.UserImp;

public class Teste {

	private static ActionEvent actionEvent;
	
	public static void main(String[] args) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
	
		UserImp taskImp = new UserImp();
		
		taskImp.setLogin("Luiz");
		taskImp.setNome("Luiz Fernando");
		taskImp.setPassword("123");
		
	System.out.println("teste");

	session.save(taskImp);
	session.getTransaction().commit();
	session.close();
	}

}
