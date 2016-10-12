package spring.ws;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by sam on 16/9/16.
 */
public class WSClient {
    private static final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    public static void main(String args[]) throws IOException {
        String response = executeService();
        System.out.println(response);
    }

    public static String executeService() {
        StreamSource source = new StreamSource(
                new File("/home/sam/work/projects/s/connectors/sample/get_customer_request.xml"));

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        webServiceTemplate.setDefaultUri("http://localhost:3030/workday/dummy/revenue");
//        webServiceTemplate.sendSourceAndReceive()
        webServiceTemplate.sendSourceAndReceiveToResult(source, new UsernameTokenHandler(), result);
//        webServiceTemplate.
//        System.out.println(writer.toString());

        return writer.toString();
    }
}
