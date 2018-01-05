package spring.ws;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.util.XMLUtils;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecUsernameToken;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapMessage;
import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by sam on 16/9/16.
 */
public class UsernameTokenHandler implements WebServiceMessageCallback {
    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
        if (true) {
            return;
        }

        Document document = ((SoapMessage) webServiceMessage).getDocument();

        WSSecUsernameToken builder = new WSSecUsernameToken();
        builder.setPasswordType(WSConstants.PASSWORD_TEXT);
        builder.addNonce();
        builder.setUserInfo("sam", "alex");

        WSSecHeader secHeader = new WSSecHeader(document);
        secHeader.setMustUnderstand(false);
        try {
            secHeader.insertSecurityHeader();
            Document signedDoc = builder.build(document, secHeader);
            ((SoapMessage) webServiceMessage).setDocument(signedDoc);

            String outputString = XMLUtils.prettyDocumentToString(signedDoc);
            System.out.println(outputString);
        } catch (WSSecurityException e) {
            e.printStackTrace();
        }
//        soapHeader.
    }
}
