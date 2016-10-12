package http.client;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHTTPClient {
//	http://cprovapi.vervemobile.com:80/appConfigurations/byAppAndConfigKey?appId=455&configurationKey=splashad_active
	private static final String HOST = "http://cprovapi.vervemobile.com";
	private static final String METHOD = "/appConfigurations/byAppAndConfigKey?appId=455&configurationKey=splashad_active";
	private static final String DEFAULT_USER = "pub-dashboard";
	private static final String DEFAULT_PASS = "WhhB!aYu9XNU";

	public static void main(String[] args) throws Exception {
		new ApacheHTTPClient().get();

	}
	public HttpResponse get() throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("http://cprovapi.vervemobile.com:80/appConfigurations/byAppAndConfigKey?appId=455&configurationKey=splashad_active");
		System.out.println("!!!!!!!!!!HOST" + HOST);
		System.out.println("!!!!!!!!!!!!!!!!method" + METHOD);
		System.out.println("@@@@@@@@@@@@@get" + get);
		setAuthentication(get);
		HttpResponse response = client.execute(get);
		System.out.println("response!!!!!!!!" + response);

		return response;

	}

	private void setAuthentication(HttpRequestBase request) {
		String auth = DEFAULT_USER + ":" + DEFAULT_PASS;
		System.out.println("auth " + auth);

		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		System.out.println("AUTHORIZATION " + authHeader);
//		System.out.println("USER_AGENT " + USER_AGENT);
		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
//		 request.setHeader(HttpHeaders.USER_AGENT, "Mozilla );
		}
}
