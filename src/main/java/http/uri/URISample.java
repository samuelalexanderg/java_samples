package http.uri;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class URISample {
	public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
		String encodedURL = URLEncoder.encode("https://gateway-a.watsonplatform.net/calls/data/GetNews?apikey=b4cb64d514da25b1e4599770b87d3457a88de4e3&outputMode=json&start=now-7d&end=now&count=10&q.enriched.url.enrichedTitle.relations.relation=|action.verb.text=acquire,object.entities.entity.type=Company|&q.enriched.url.enrichedTitle.entities.entity=|text=Acme,type=company|&return=enriched.url.title,enriched.url.url", "UTF-8");
		System.out.println("encodedURL : " + encodedURL);
		URI uri = new URI(encodedURL);
		System.out.println(uri.getHost());
	}
}
