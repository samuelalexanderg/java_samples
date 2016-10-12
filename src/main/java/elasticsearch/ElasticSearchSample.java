package elasticsearch;

import java.net.InetAddress;
import java.util.Map;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ElasticSearchSample {
	public static void main(String[] args) throws Exception {
		Client client = TransportClient.builder().build()
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("dev.es.dev.audiencehub.sizmdx.com"), 9300));
		String json = "{\"name\": \"Elastic Search\",\"description\": \"SparkXMLUtilsSample data\"}";
		client.prepareIndex("fakeservices", "data").setSource(json).execute().get();


		GetRequest getRequest = new GetRequest("fakeservices");
		ActionFuture<GetResponse> actionFuture = client.get(getRequest);
		GetResponse actionGet = actionFuture.actionGet();
		Map<String, Object> msg = actionGet.getSource();
		System.out.println("Message : " + msg);
	}
}
