package string;

public class StringTest {
	public static void main(String[] args) {
		String[] split = "nwk=".split("=");
		System.out.println(split.length);
		System.out.println(split[0]);
	}
}
