package jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;

import jetty.handler.OptionsHandler;
import jetty.handler.OtherHandler;

public class SampleServer {
	public static void main(String args[]) throws Exception {
        Server server = new Server(2020);
        HandlerList handlers = new HandlerList();
        // Replace OtherHandler with your current handler
        // But please make sure OptionsHandler is first in the list
        handlers.setHandlers(new Handler[] {new OptionsHandler(), new OtherHandler()});
        server.setHandler(handlers);
        server.start();
        server.join();

        // Not needed
        System.out.println("Press any key to stop server...");
        server.stop();
	}
}
