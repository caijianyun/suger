package com.cjy.suger.main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author liuyazhuang
 * @time 2015-10-22
 * 
 */
public class Gotourl {

	/**
	 * ��IE���������ҳ��
	 */
	public static void openIEBrowser() {
		// ����cmd����IE�ķ�ʽ������ַ��
		String str = "cmd /c start iexplore http://blog.csdn.net/l1028386804";
		try {
			Runtime.getRuntime().exec(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��Ĭ�����������ҳ��
	 */
	public static void openDefaultBrowser() {
		// ����ϵͳĬ�������������ַ��
		try {
			URI uri = new URI("http://blog.csdn.net/l1028386804");
			Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		openIEBrowser();
		openDefaultBrowser();
	}
}
