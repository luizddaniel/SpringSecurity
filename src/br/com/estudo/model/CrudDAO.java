package br.com.estudo.model;

import java.util.List;

public interface CrudDAO<E> {

	public void salvar(E entidade) throws Error;

	public void deletar(E entidade) throws Error;

	public void editar(E entidade) throws Error;

	public List<E> listar() throws Error;
}
