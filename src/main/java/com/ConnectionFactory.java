package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    public ConnectionFactory() {
    }

    public static ConnectionFactory getInstance(){
        if(instance == null) instance = new ConnectionFactory();
        return instance;
    }

    public Connection get(){
        try{
            String url = "jdbc:postgresql://localhost:5432/smart_rh";
            String user = "postgres";
            String senha = "postgres";

            Connection conn = DriverManager.getConnection(url, user, senha);
            return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
