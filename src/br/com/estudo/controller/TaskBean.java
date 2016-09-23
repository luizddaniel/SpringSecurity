package br.com.estudo.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.estudo.model.TaskDAO;
import br.com.estudo.model.TaskImp;

@ManagedBean
@SessionScoped
public class TaskBean extends CrudBean<TaskImp, TaskDAO> {

	private TaskDAO taskDAO;

	@Override
	public TaskDAO getDao() {
		if (taskDAO == null) {
			taskDAO = new TaskDAO();
		}
		return taskDAO;
	}

	@Override
	public TaskImp criarNovaEntidade() {
		return new TaskImp();
	}
	
	 public void delete() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

}
