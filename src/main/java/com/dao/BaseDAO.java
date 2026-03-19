package com.dao;

import com.ConnectionFactory;

import java.sql.Connection;

public abstract class BaseDAO {

    public Connection conn(){
        return ConnectionFactory.getInstance().get();
    }
}
