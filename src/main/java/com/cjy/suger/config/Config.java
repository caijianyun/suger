package com.cjy.suger.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static Properties getSystemProps()  
    {  
        Properties props = new Properties();  
  
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("suger.properties");  
        try {  
        	if(null != in){
        		props.load(in);  
        	}else{
        		props.load(loadOtherResources());
        	}
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        return props;  
    }  
	
	static InputStream loadOtherResources(){
		InputStream in = null;
		String filePath = getSysPath() + File.separator + "conf" + File.separator + "suger.properties";
		try {
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return in;
	}
	
	public static String getSysPath(){
		String sysPath = System.getProperty("user.dir");
		if(sysPath.endsWith("bin")){
			sysPath = sysPath.substring(0, sysPath.length()-4);
		}
		return sysPath;
	}
	
	public static void main(String[] arg){
		String str = "C:\\Users\\Administrator\\Desktop\\suger\\bin";
		System.out.println(str.substring(0,str.length()-4));
	}
}
