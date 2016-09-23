package br.com.estudo.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.estudo.model.UserDAO;
import br.com.estudo.model.UserImp;

@ManagedBean
@SessionScoped
public class UserBean extends CrudBean<UserImp, UserDAO> {

	private UserDAO userDAO;

	@Override
	public UserDAO getDao() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	@Override
	public UserImp criarNovaEntidade() {
		return new UserImp();
	}
	
	 public void delete() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

}
