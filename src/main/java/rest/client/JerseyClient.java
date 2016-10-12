package rest.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.WebTarget;

public class JerseyClient {

	private static final String HEADER_AUTH = "Authorization";
	private static final String HEADER_INSTANCE_URL = "InstanceURL";

	public static void main(String[] args) {
	    Client client = ClientFactory.newClient();
//	    http://cprovapi.vervemobile.com/appConfigurations/byAppAndConfigKey?appId=455&configurationKey=splashad_active
	    WebTarget target = client.target("http://cprovapi.vervemobile.com").path("/appConfigurations/byAppAndConfigKey");
	    target.queryParam("appId", 455).queryParam("configurationKey", "splashad_active");

	    Notebooks notebooks = target.request()
	            .header(HEADER_AUTH, "token 00DB00000001VXT!AR4AQIiQzb5TtVWlk1LUqQ1IKaRu.5QHScCu520PI3xWF1S_Zp2k.mBRf.m6BvpEfMOMZDq5OIwI2N0yUsMoc2i9z1UB205W")
	            .header(HEADER_INSTANCE_URL, "https://gs0.salesforce.com")
	            .get(Notebooks.class);

	    List<String> notebookKeys = new ArrayList<String>();
	    List<Note> notebookList = notebooks.getNotebooks();
	    if (notebookList != null && !notebookList.isEmpty()) {
	      for (Note note : notebookList) {
	        notebookKeys.add(note.getId());
	      }
	    }

	    System.out.println("Allowed notebooks " + notebookKeys);

	}
}
