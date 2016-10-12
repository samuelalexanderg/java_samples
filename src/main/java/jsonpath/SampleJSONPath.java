package jsonpath;

import java.io.File;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class SampleJSONPath {
	public static void main(String[] args) throws Exception {
		List<Integer> result = JsonPath.read(new File("/home/sam/tmp/adv.json"), "$.result[*].id");
		System.out.println(result);
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).toString());
//		}
	}

	private static void test() {
		String jsonContent = "{\"request\":{\"ip\":\"127.0.0.1\",\"referer\":{\"string\":\"\"},\"user_agent\":{\"string\":\"integration-tester\"}},\"timestamp\":\"2016-04-04T05:48:28.894Z\",\"uid\":{\"string\":\"aaaa\"},\"params\":{\"map\":{\"e\":\"cta_map\",\"r\":\"1459748908890yVgzhVJa6y\"}},\"adserver\":{\"map\":{}}}";
		Object result = JsonPath.read(jsonContent, "$.params.map.e");
		System.out.println("result class name : " + result.getClass().getName());
		System.out.println("result  : " + result);
//		List<String> e = JsonPath.read(jsonContent, "$.params.map.e");
	}
}
