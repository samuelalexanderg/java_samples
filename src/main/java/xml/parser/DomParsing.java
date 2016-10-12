package xml.parser;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DomParsing {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		InputStream is = readHTTPContent();
		Document document = builder.parse(is);

		printDoc(document);

		NodeList elements = document.getElementsByTagName("City");
		for (int i = 0; i < elements.getLength(); i++) {
			org.w3c.dom.Element item = (org.w3c.dom.Element) elements.item(i);

			System.out.println(item.getNodeName());
			System.out.println(item.getNodeType());

			System.out.println("Name : " + item.getAttribute("Name"));
		}
	}

	private static void printDoc(Document document) throws Exception {
		DOMSource domSource = new DOMSource(document);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);

		System.out.println("Doc : " + writer.toString());
	}

	private static InputStream readHTTPContent() throws Exception {
		HttpGet httpGet = new HttpGet(
				"http://data-services.wsi.com/200904-01/173981861/Locations/Cities/13.096039/80.234146");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		return response.getEntity().getContent();
	}
}
