package br.status.rt;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

public class App {

	private int port = 8980;

	public static void main(String[] args) throws Exception {
		System.out.println("Starting application...");

		App app = new App();

		if (System.getProperty("server.bind.port") != null && System.getProperty("server.bind.port").length() > 0) {
			app.port = Integer.parseInt(System.getProperty("server.bind.port"));
			System.out.println("Got port from env " + app.port);
		} else {
			System.out.println("No port set using default " + app.port);
		}
		app.startSimpleEchoServer();
		// app.startWebSocketServer();
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
