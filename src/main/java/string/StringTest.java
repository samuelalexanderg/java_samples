package string;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("22"));
//		substringTest();
//		stringBuilderTest();
//		replaceToken();
//		replaceAll();
//		subStringUsingIndex();
//		patternMatch();
//		compareTo();
//		replacePattern();
//		doubleFormat();
//		tokenizeTest();

	}

	private static void tokenizeTest() {
		Matcher m = Pattern.compile("([^\']\\S*|\'.+?\')\\s*").matcher("Hello 'Samuel Alexander'");
		while (m.find()) {
			System.out.println(m.group(1).replaceAll("'", ""));
		}
//		StringTokenizer st = new StringTokenizer("Hello 'Samuel Alexander'", " ");
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
	}

	private static void doubleFormat() {
		double d = 4345d;
		System.out.println("String.valueOf" + String.valueOf(d));
		System.out.println("String.format" + String.format("%d", (long)d));
	}

	private static void compareTo() {
		System.out.println("0.97".compareTo("25"));
		System.out.println("10000000".compareTo("25"));
		System.out.println("-10000000".compareTo("25"));
	}

	private static void replacePattern() {
		String pattern = "<";
		String email = "emailTo<sam@sample.com>";
		System.out.println(email.replaceAll(pattern, "sdf"));
	}

	private static void patternMatch() {
		    //public static Pattern RECORD_PATTERN = Pattern.compile("([0-9a-zA-Z]-?)+ [0-9a-zA-Z,]+ ?[0-9a-zA-Z,]*");
	    Pattern RECORD_PATTERN = Pattern.compile("[\\S]+[ |\\|]?[^\\s]+(,[^\\s,]+)*");
//	    Pattern RECORD_PATTERN = Pattern.compile("[\\S]+[ \\|]?([\\S],)*");

		String line = "ffba470a-75f5-4613-857c-f205bd15f101-777";

		Matcher matcher = ((Pattern) RECORD_PATTERN).matcher(line);

		if (matcher.matches()) {
			System.out.println("fileName is valid");
		} else {
			System.out.println("fileName is invalid-------");
		}

	/*
		StringBuilder INPUT_FILE_PATTERN = new StringBuilder().append("C")
				.append("(?<flowChunkNumber>[0-9]+?)_")
				.append("UsrSegs_").append("(?<type>Incr|Full?)_")
				.append("(?<splitNumber>([0-9])*?)_*")
				.append("(?<chunkNumber>([0-9])*?)_*")
				.append("(?<timestamp>[0-9]{8}[T][0-9]{6}\\.[0-9]{6}?)_")
				.append("(?<randomNumber>[0-9]+[^_])?$");

		Pattern inputFilePattern = Pattern.compile(INPUT_FILE_PATTERN.toString());

//		Matcher matcher = inputFilePattern.matcher("C2_UsrSegs_Incr_2_8_20160520T164238.485000_552118");
		Matcher matcher = inputFilePattern.matcher("C1_UsrSegs_Full_20150330T115300.000000_935156");
		System.out.println(matcher.matches());
		System.out.println(matcher.group("flowChunkNumber"));
		System.out.println(matcher.group("type"));
		System.out.println(matcher.group("splitNumber"));
		System.out.println(matcher.group("chunkNumber"));
		System.out.println(matcher.group("timestamp"));
		System.out.println(matcher.group("randomNumber"));


//		StringBuilder INPUT_FILE_PATTERN = new StringBuilder().append("C").append("(?<flowChunkNumber>[0-9]+?)$");
//		Pattern inputFilePattern = Pattern.compile(INPUT_FILE_PATTERN.toString());
//		Matcher matcher = inputFilePattern.matcher("C1");
//		matcher.
//		System.out.println(matcher.matches());
//		System.out.println(matcher.group("flowChunkNumber"));
//		String pattern = "sample*".replaceAll("\\*", ".*");
//		System.out.println("pattern" + pattern);
//		String toBeMatched = "sample1.csv";
//		System.out.println(Pattern.matches(pattern, toBeMatched));

//		String pattern = ".*20160218_..-50-58.220.*";
//		String toBeMatched = "test/dev/adobe/adobe-ci/output/2016/01/06/UsrSegs_Incr_20160106T191100.642000_323056";
//		System.out.println(Pattern.matches(pattern, toBeMatched));
 * */

	}

	private static void subStringUsingIndex() {
		String message = "Exception caught while executing runLayoutTest: {\"rule_1\":{\"Exists\":true},\"rule_2\":{\"Exists\":true,\"EqualHeight\":false},\"rule_3\":{\"AlignedLeft\":false}}";
		int colonIndex = message.indexOf(":");
		String json = null;
		if (colonIndex != -1) {
			json = message.substring(colonIndex + 1);
		}

		System.out.println(json);
	}

	private static void replaceAll() {
		String content = "#//Make Dummy on {FIELD_NAME} fielddrop_cols <- c(\"{FIELD_NAME}\")localMyDF <- cbind(localMyDF, df_dummies)";
		System.out.println(content.replaceAll("\\{FIELD_NAME\\}", "dummy"));
	}

	private static void replaceToken() {
//		String ste = "{name} is {char} {gender}";
		String ste = "Sam is a good man";
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("name", "Sam");
		replacements.put("char", "Good");
		replacements.put("gender", "Man");

		Pattern pattern = Pattern.compile("\\{([^}]+)\\}");
		Matcher matcher = pattern.matcher(ste);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			String replacement = replacements.get(matcher.group(1));
			if (replacement != null) {
//				matcher.appendReplacement(buffer, replacement);
				// see comment
				matcher.appendReplacement(buffer, "");
				buffer.append(replacement);
			}
		}
		matcher.appendTail(buffer);
		System.out.println(buffer.toString());
	}

	private static void stringBuilderTest() {
		StringBuilder sb = new StringBuilder();
		String s = null;
		sb.append(s);
		sb.append("sdf");

		System.out.println(sb);
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
