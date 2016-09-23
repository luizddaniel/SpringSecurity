package br.com.estudo.controller;

import br.com.estudo.model.CrudDAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

public abstract class CrudBean<E, D extends CrudDAO> {

	 private String estadoTela = "buscar";//Inserir, Editar, Buscar
	    
	    private E entidade;
	    private List<E> entidades;
	    
	    public void novo(){
	        entidade =  criarNovaEntidade();
	        mudarParaInseri();
	    }
	    
	    public void salvar(){
	        try {
	            getDao().salvar(entidade);
	            entidade = criarNovaEntidade();
	            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
	            mudarParaBusca();
	        } catch (Error ex) {
	            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
	            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
	        }
	    }
	    public void editar(E entidade){
	    	 try {
	    		 	this.entidade = entidade;
		            getDao().editar(entidade);
		            entidade = criarNovaEntidade();
		            adicionarMensagem("Altere os Dados!", FacesMessage.SEVERITY_INFO);
		            mudarParaBusca();
		        } catch (Error ex) {
		            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
		            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		        }
	    	 mudarParaInseri();
	    }
	    public void deletar(E entidade){
	        try {
	            getDao().deletar(entidade);
	            entidades.remove(entidade);
	            adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
	        } catch (Error ex) {
	            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
	            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
	        }
	    }
	    public void buscar(){
	        if(isBusca() == false){
	           mudarParaBusca();
	           return;
	        }
	        try {
	            entidades = getDao().listar();
	            if(entidades == null || entidades.size() < 1){
	                adicionarMensagem("Não temos nada cadastrado!", FacesMessage.SEVERITY_WARN);
	            }
	        } catch (Error ex) {
	            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
	            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
	        }
	    }
	    
	    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro){
	        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
	        FacesContext.getCurrentInstance().addMessage(null, fm);
	    }
	    
	    //getters e setters
	    public E getEntidade() {
	        return entidade;
	    }

	    public void setEntidade(E entidade) {
	        this.entidade = entidade;
	    }

	    public List<E> getEntidades() {
	        return entidades;
	    }

	    public void setEntidades(List<E> entidades) {
	        this.entidades = entidades;
	    }
	    
	    //Responsvel por criar os métodos nas classes bean
	    public abstract D getDao();
	    public abstract E criarNovaEntidade();
	    
	    //Metodos para controle da tela
	    public boolean isInseri(){
	        return "inserir".equals(estadoTela);
	    }
	    public boolean isEdita(){
	        return "editar".equals(estadoTela);
	    }
	    public boolean isBusca(){
	        return "buscar".equals(estadoTela);
	    }
	    public void mudarParaInseri(){
	        estadoTela = "inserir";
	    }
	    public void mudarParaEdita(){
	        estadoTela = "editar";
	    }
	    public void mudarParaBusca(){
	        estadoTela = "buscar";
	    }
}
