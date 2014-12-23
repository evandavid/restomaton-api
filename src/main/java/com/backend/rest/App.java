package com.backend.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.backend.rest.services.Users;


public class App {
    public static void main(String[] args) throws Exception {
    	// start server
        ServletContextHandler context =
            new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(7000);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        @SuppressWarnings("rawtypes")
		Class[] classess = { Users.class };
        for (int i = 0; i < classess.length; i++) {
        	jerseyServlet.setInitParameter(
	           "jersey.config.server.provider.classnames",
	           classess[i].getCanonicalName());
		}

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
