package com.cjy.suger.main;

import java.util.Properties;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import com.cjy.suger.config.Config;
import com.cjy.suger.db.DBConnFactory;
import com.cjy.suger.db.DBConnection;
import com.cjy.suger.util.Log;


public class JettyMain {
	
	public static void main(String[] args) {
		Properties props = Config.getSystemProps();
		Object prot = props.get("server.port");
		if (prot == null) {
			System.out.println("port is empty");
			System.exit(1);
		}
		// �������ļ����˿�
		Server server = new Server(Integer.valueOf(prot.toString()));
		// ����һ���Ѿ����ڵ�������
		WebAppContext context = new WebAppContext();
		// ����������λ��
		context.setDescriptor(Config.getSysPath() + "/resources/webapp/WEB-INF/web.xml");
		// ����Web����������·��
		context.setResourceBase(Config.getSysPath() + "/resources/webapp");
		// ����������·��
		context.setContextPath("/JettyDemo");
		context.setParentLoaderPriority(true);
		server.setHandler(context);
		//new DBConnection().connect();
		DBConnFactory.getInstance();
		DBConnFactory.reload();
		try {
			server.start();
			// server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.info("server is  start");
	}

}
