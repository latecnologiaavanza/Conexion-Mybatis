package com.pe.tecnologia.implementacion;

import com.pe.tecnologia.dao.ConexionDAO;
import com.pe.tecnologia.dao.MySessionFactory;
import org.apache.ibatis.session.SqlSession;

public class ConexionImp implements ConexionDAO {

    private final MySessionFactory instancia = MySessionFactory.getInstance();

    @Override
    public String getVersionMysql() {
        String version = "";
        SqlSession session = null;
        
        try{
            session = instancia.getFactory().openSession();
            version = session.selectOne("mysqlVersion");
        }catch(Exception error){
            System.out.println(error);
        }finally{
            if(session != null){
                session.close();
            }
        }
        
        return version;
    }

}
