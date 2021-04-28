package com.pe.tecnologia.dao;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySessionFactory {

    private static MySessionFactory instancia;
    private SqlSessionFactory factory;

    private MySessionFactory() {
        String recurso = "mybatis-config.xml";
        Reader lector = null;

        try {
            lector = Resources.getResourceAsReader(recurso);
            factory = new SqlSessionFactoryBuilder().build(lector);
            lector.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    public static MySessionFactory getInstance() {
        if (instancia == null) {
            instancia = new MySessionFactory();
        }
        return instancia;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}
