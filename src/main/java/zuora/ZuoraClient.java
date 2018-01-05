package zuora;

import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Created by sam on 7/12/16.
 */
public class ZuoraClient {
    private WebServiceTemplate webServiceTemplate;

    public ZuoraClient(String endpoint) {
        webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri(endpoint);
    }

    public String createAccount(String sessionId, String requestFileLocation) {
        StreamSource source = new StreamSource(
                new File(requestFileLocation));
        return null;
    }
}
