package com.cjy.suger.db;

import java.beans.PropertyVetoException;  
import java.sql.Connection;  
import java.sql.SQLException;
import java.util.Properties;


import com.cjy.suger.config.Config;
import com.cjy.suger.util.Log;
import com.mchange.v2.c3p0.ComboPooledDataSource;  
  
public final class DBConnFactory {  
    //ʹ�õ���ģʽ�������ݿ����ӳ�  
    private static DBConnFactory instance;  
    private static ComboPooledDataSource dataSource;  
  
    private DBConnFactory() throws SQLException, PropertyVetoException {  
    	Properties props = Config.getSystemProps();
    	if(null == props.getProperty("db.user") || null == props.getProperty("db.password")
    			|| null == props.getProperty("db.url") || null == props.getProperty("db.driver")){
    		Log.warn("Can not initialize the data pool, the lack of the necessary parameters");
    		return ;
    	}
    	dataSource = new ComboPooledDataSource();  
  
        dataSource.setUser(props.getProperty("db.user"));     //�û���  
        dataSource.setPassword(props.getProperty("db.password")); //����  
        dataSource.setJdbcUrl(props.getProperty("db.url"));//���ݿ��ַ  
        dataSource.setDriverClass(props.getProperty("db.driver"));  
        dataSource.setInitialPoolSize(Integer.valueOf(props.getProperty("db.size")==null?"5":props.getProperty("db.size"))); //��ʼ��������  
        dataSource.setMinPoolSize(Integer.valueOf(props.getProperty("db.min")==null?"1":props.getProperty("db.min")));//��С������  
        dataSource.setMaxPoolSize(Integer.valueOf(props.getProperty("db.size")==null?"10":props.getProperty("db.size")));//���������  
        dataSource.setMaxStatements(50);//��ȴ�ʱ��  
        dataSource.setMaxIdleTime(60);//������ʱ�䣬��λ����  
    }  
  
    public static final DBConnFactory getInstance() {  
        if (instance == null) {  
            try {  
                instance = new DBConnFactory();  
                Log.info("Database pool has init sucessed");
            } catch (Exception e) { 
            	Log.error("Database pool init failed",e);
            }  
        }  
        return instance;  
    }  
  
    public static final void reload(){
    	
    	try {
			instance = new DBConnFactory();
			Log.info("Database pool has reload");
		} catch (SQLException e) {
			Log.error("reload Database pool error",e);
		} catch (PropertyVetoException e) {
			Log.error("reload Database pool error",e);
		}
    	
    }
    
    public synchronized final Connection getConnection() {  
        Connection conn = null;  
        try {  
            conn = dataSource.getConnection();  
        } catch (SQLException e) {  
            Log.error("Can not initialize the data pool, the lack of the necessary parameters");  
        }  
        return conn;  
    }  
}
