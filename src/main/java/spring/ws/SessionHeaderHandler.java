package spring.ws;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;

/**
 * Created by sam on 16/11/16.
 */
public class SessionHeaderHandler implements WebServiceMessageCallback {
    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
        SoapHeader soapHeader = ((SoapMessage) webServiceMessage).getSoapHeader();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new StringSource(getSessionHeader()), soapHeader.getResult());
        transformer.transform(new StringSource(getQueryOptions()), soapHeader.getResult());
//        transformer.transform(new StringSource(getSessionHeader()), soapHeader.getResult());
    }

    private String getQueryOptions() {
        return "<api:QueryOptions xmlns:api=\"http://api.zuora.com/\">\n" +
                " <api:batchSize>2</api:batchSize>\n" +
                " <api:caseSensitive>false</api:caseSensitive>\n" +
                " <api:fastQuery>false</api:fastQuery>\n" +
                "</api:QueryOptions>";
    }

    private String getSessionHeader() {
        return "      <api:SessionHeader xmlns:api=\"http://api.zuora.com/\">\n" +
                "         <api:session>zQ45Mlzp0x6M1IgM_QFrgM457ddkXM7AnuMMpd2zZLt5cmckUmDtt_vO13LSaehYs9Sic01WoLUWDIB6G8Gr1H7puI6Lvoue-AETf76DxhkrrnJDkQ4x1YHth_DVXTWrIA9fChlsJDtX18JJB5W2y04HWCPfr6shQAg4pSBkNdt7Bhav6AAsPtXY7oZLVGTs9gTrnEiEObZiwGTSDBpE7xJTz1X2VZVVPLFxzKZtSuBy3bt5GNspBPM9y4oxfXWzovEn9Y40lpHEauVNgqfzHwWsGGG5kt_mdI68wSKcp1oRJYG2S0OcZg3z2cSFQCUrjcLM1oYNokWYx3f22CK68VbqwO22doIgfUEHoIYbEOE=</api:session>\n" +
                "      </api:SessionHeader>";

    }
}
