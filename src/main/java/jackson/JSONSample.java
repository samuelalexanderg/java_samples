package jackson;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSample {
	public static void main(String[] args) throws Exception {
		parseAsMap();
		System.out.println(getSegmentNames("{\"IDNAME\":{\"NAME\":[\"<segment_name>\"]}}"));
		System.out.println(getSegmentNames("{\"IDNAME\":{\"NAME\":[\"segment_name1\",\"segment_name2\"]}}"));
		System.out.println(getSegmentNames("segment_name"));
	}

	private static List<String> getSegmentNames(String json) throws Exception {
		try {
//			new ObjectMapper().writeValueAsString(value)
			Map<String,Map<String, List<String>>> result = new ObjectMapper().readValue(json, Map.class);
			Map<String, List<String>> nameMap = result.get("IDNAME");
			return nameMap.get("NAME");
		} catch (JsonParseException e) {
			// provided String is not JSON
			return Arrays.asList(json);
		}
	}

	private static void parseAsMap() throws Exception {
//		String json = "{\"includedSegments\":[\"24950\",\"24948\",\"24949\"], \"operator\":\"AND\", \"subqueries\":[{\"segment\":\"24950\"},{\"operator\":\"OR\",\"subqueries\":[{\"segment\":\"24948\",\"operator\":\"NOT\"},{\"segment\":\"24949\"}]}]}";
		String json = "{\"1\":{\"NAME\":[\"segment\"]},\"2\":{\"NAME\":[\"click\"]}}";
		Map<String,Map<String, String>> result = new ObjectMapper().readValue(json, Map.class);
		Collection<Map<String,String>> values = result.values();
		}

//		List<String> segments = (List<String>) result.get("includedSegments");
//		for (String segmentId : segments) {
//			System.out.println(segmentId);
//		}


}
