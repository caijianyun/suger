package com.cjy.suger.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	private static Logger logger = LoggerFactory.getLogger(Log.class);
	
	public static void info(String msg){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace(); 
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.info(msg);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}  
	
	public static void info(String msg,Object object){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.info(msg,object);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}
	
	public static void error(String errorMsg){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.error(errorMsg);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}
	
	public static void error(String errorMsg,Object object){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.error(errorMsg,object);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}
	
	public static void warn(String warnMsg){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.error(warnMsg);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}
	
	public static void warn(String warnMsg,Object object){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
		String className = stack[2].getClassName();
        Logger log;
		try {
			log = LoggerFactory.getLogger(Class.forName(className));
			log.error(warnMsg,object);
		} catch (ClassNotFoundException e) {
			logger.error("初始化日志类文件失败",e);
		}
	}
	
	
}
