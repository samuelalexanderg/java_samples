package http.filter;

public class URLFilter {

	public static void main(String[] args) {
		String url = args[0];
		if (url.contains("sam")) {
			System.exit(0);
		}

		System.exit(1);
	}

}
