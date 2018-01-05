package spring.ws;

import org.apache.axiom.soap.SOAPHeader;
import org.apache.axiom.soap.SOAPMessage;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.axiom.AxiomSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by sam on 21/10/16.
 */
public class SoapHeaderHandler implements WebServiceMessageCallback {
    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
        SOAPMessage soapMessage = ((AxiomSoapMessage) message).getAxiomMessage();
        SOAPHeader soapHeader = soapMessage.getSOAPEnvelope().getHeader();
//        SoapHeaderElement searchPreferences = soapHeader.addHeaderElement(
//                    new QName("urn:messages_2016_1.platform.webservices.netsuite.com", "searchPreferences"));
    }
}
