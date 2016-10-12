package parameters;

public class OptionalParameters {

	public static void main(String args[]) {
		printParameters("param1", new String[] {"a", "b"});
	}

	private static void printParameters(String param1, String... optionalParams) {
		System.out.println("Param1 " + param1);
		for (String optParam : optionalParams) {
			System.out.println(optParam);
		}
	}
}
