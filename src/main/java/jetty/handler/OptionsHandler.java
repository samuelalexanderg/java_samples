package jetty.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class OptionsHandler extends AbstractHandler {

	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String method = request.getMethod();
		if (HttpMethod.OPTIONS.is(method)) {
			// Set the required headers over here
	        response.setContentType("application/json;charset=utf-8");
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.addHeader("Options_Handler", "true");
	        response.addHeader("Other_Handler", "false");
	        // Setting the handled to true will make the request not passed to other handlers
	        baseRequest.setHandled(true);
		}
	}

}
