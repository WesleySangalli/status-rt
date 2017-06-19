package br.status.rt;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ClientEndpoint
@ServerEndpoint("/status/")
public class StatusSocket {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("WebSocket open");
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("Received message: " + message);
		sendBack(message, session);
	}

	@OnClose
	public void onClose(CloseReason reason) {
		System.out.println("WebSocket closed");
	}

	@OnError
	public void onWebSocketError(Throwable cause) {
		cause.printStackTrace(System.err);
	}

	private void sendBack(String message, Session session) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
