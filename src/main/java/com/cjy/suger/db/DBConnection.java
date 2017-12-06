package com.cjy.suger.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.cjy.suger.config.Config;
import com.cjy.suger.util.Log;

public class DBConnection {
	
	public Connection conn = null;
	
	public void connect(){
		Properties props = Config.getSystemProps();
		String dbUrl = props.getProperty("db.url").toString();
		String dbDriverName = props.getProperty("db.driver").toString();
		String dbUser = props.getProperty("db.user").toString();
		String dbPassWord = props.getProperty("db.password").toString();
		try {
			Class.forName(dbDriverName);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassWord);
			Log.info("Database is Connected");
		} catch (Exception e) {
			Log.error("Database Connect error",e);
		}
	}
	
	
}
