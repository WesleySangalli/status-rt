package br.status.rt;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * TODO Use unit tests
 */
public class Client {

	public static void main(String[] args) {
		URI uri = URI.create("ws://localhost:8980/status/");

		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		Session session;
		try {
			session = container.connectToServer(StatusSocket.class, uri);
			session.getBasicRemote().sendText("Hello");
			session.close();
		} catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
