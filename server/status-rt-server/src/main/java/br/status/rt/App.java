package br.status.rt;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

public class App {

	private static final int port = 8980;

	public static void main(String[] args) throws Exception {
		App app = new App();
//		app.startSimpleEchoServer();
		app.startWebSocketServer();
	}

	private void startWebSocketServer() throws Exception {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(port);
		server.addConnector(connector);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
		wscontainer.addEndpoint(StatusSocket.class);

		server.start();
		server.dump(System.err);
		server.join();
	}

	private void startSimpleEchoServer() throws Exception {
		Server server = new Server(port);
		server.setHandler(new EchoHandler());

		server.start();
		server.join();
	}
}
