package string;

public class StringTest {
	public static void main(String[] args) {
		substringTest();
	}
	
	public static void substringTest() {
		String configFileLocation = "gs://sam-bucket1/SampleAdData/ad-server-data1.csv";
		configFileLocation = configFileLocation.substring(5);
		int slashIndex = configFileLocation.lastIndexOf('/');
		if (slashIndex != -1) {
			String bucket = configFileLocation.substring(0, slashIndex);
			String fileName = configFileLocation.substring(slashIndex + 1);
			System.out.println(bucket);
			System.out.println(fileName);
		}
	}
	public static void splitText() {
		String[] split = "nwk=".split("=");
		System.out.println(split.length);
		System.out.println(split[0]);
	}
}
