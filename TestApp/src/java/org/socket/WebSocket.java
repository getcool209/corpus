/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socket;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author gaura
 */
@ServerEndpoint("/actions")
public class WebSocket {
    
    @OnOpen
    public void onOpen(Session session){
//        System.out.println(session.getId() + " has opened a connection"); 
//        try {
//            session.getBasicRemote().sendText("Connection Established");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    @OnError
    public void onError(Throwable t) {
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Session " +session.getId()+" has ended");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
