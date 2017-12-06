package com.cjy.suger.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import com.cjy.suger.util.Log;  
   

public final class ReverseAjaxServlet extends WebSocketServlet {  
   
	private static final long serialVersionUID = 1L;
	private final Endpoints endpoints = new Endpoints();  
    private final Random random = new Random();  
    private final Thread generator = new Thread("Event generator") {  
        @Override  
        public void run() {  
        	Log.info("websocket starting...");
            while (!Thread.currentThread().isInterrupted()) {  
                try {  
                    Thread.sleep(random.nextInt(5000));  
                    endpoints.broadcast(new JSONArray().put("At " + new Date()).toString());  
                } catch (InterruptedException e) {  
                    Thread.currentThread().interrupt();  
                }  
            }  
        }  
    };  
   
    @Override  
    public void init() throws ServletException { 
    	Log.info("websocket is initing...");
        super.init();  
        //generator.start();  
    }  
   
    @Override  
    public void destroy() {  
        generator.interrupt();  
        super.destroy();  
    }  
       
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {  
        Log.info("websocket new  EndPoint");
    	return endpoints.newEndpoint();  
    }  
   
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        resp.getWriter().write("11111");  
    }  
}  