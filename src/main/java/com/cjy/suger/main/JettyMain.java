package com.cjy.suger.main;

import java.util.Properties;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cjy.suger.config.Config;


public class JettyMain {
	private static Logger log = LoggerFactory.getLogger(JettyMain.class);

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

		try {
			server.start();
			// server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("server is  start");

	}

}
