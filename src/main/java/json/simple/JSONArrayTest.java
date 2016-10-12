package json.simple;

import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class JSONArrayTest {
	public static void main(String args[]) {
	    try {
//	        JSONObject jsonObject = new JSONObject(json);
//	        JSONArray jsonArray = jsonObject.getJSONArray("result");
	    	JSONObject jsonObject = new JSONObject();
	    	JSONArray jsonArray = new JSONArray();
	        for (int i = 0; i < 3; i++) {
	            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//	            JSONObject innerJosonObject = new JSONObject(jsonArray.getString(i));

	            // you need to put all values from jsonObject to map for managing the order..

	            linkedHashMap.put("doc_no", "Check");
	            linkedHashMap.put("itembarcode", "itembarcode");
	            linkedHashMap.put("net_wt", "net_wt");
	            linkedHashMap.put("gross_wt", "gross_wt");
	            linkedHashMap.put("stone_wt", "stone_wt");
	            linkedHashMap.put("stone_amt", "stone_amt");
	            linkedHashMap.put("rate", "rate");
	            linkedHashMap.put("making", "making");
	            linkedHashMap.put("qty", "qty");
	            linkedHashMap.put("net_rate", "net_rate");
	            linkedHashMap.put("item_total", "item_total");
	            linkedHashMap.put("sum_total", "sum_total");
	            Gson gson = new Gson();
	            // convert linkedHashMap to json string and it will keep the insertion order..
	            String string = gson.toJson(linkedHashMap, LinkedHashMap.class);
	            jsonArray.put(i, string);
	        }
	        jsonObject.put("result", jsonArray);
	        String jsonResp = jsonArray.toString();
	        String jsonFormattedString = jsonResp.replaceAll("\\\\","");
	        System.out.println("NEW JSON " + jsonFormattedString);

	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	}
}
