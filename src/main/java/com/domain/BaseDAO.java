package com.domain;

import com.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public interface BaseDAO<T> {

    default Connection conn(){
        return ConnectionFactory.getInstance().get();
    }

    public void salvar(T entity);
    public List<T> obter();
    public void deletar(Long id);
    public void atualizar(T entity);

}
