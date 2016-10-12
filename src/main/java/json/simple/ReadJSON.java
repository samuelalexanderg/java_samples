package json.simple;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {
	public static void main(String[] args) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject pagesObject = (JSONObject) parser.parse(new FileReader("/home/sam/tmp/test.json"));
//		System.out.println(pagesObject.get("id"));
//		System.out.println(pagesObject.get("pages").getClass().getCustomer_name());
		JSONArray jsonArray= (JSONArray) pagesObject.get("pages");
		System.out.println(jsonArray.size());

		for(int i=0; i<jsonArray.size(); i++){
		}
	}
}
