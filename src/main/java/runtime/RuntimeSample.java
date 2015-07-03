package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeSample {
	public static void main(String[] args) throws Exception {
		Process process = startSauceConnect();
		
		// Stop sauce connect
		process.destroy();
	}

	private static Process startSauceConnect() throws IOException, Exception {
		Process process = Runtime.getRuntime().exec(
				"/home/sam/work/software/sc-4.3.8-linux/bin/sc -u karunakaran");
		for (int i = 0; i < 5; i++) {
			if (isSauceConnectStarted(process)) {
				break;
			}
		}
		
		if (!isSauceConnectStarted(process)) {
			throw new Exception("Not able to start Sauce Connect. See Console for more details...");
		}
		return process;
	}

	private static boolean isSauceConnectStarted(Process process) throws Exception {
		// Waiting 5 seconds
		Thread.sleep(5000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				process.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			if (line.contains("started")) {
				return true;
			}
		}

		return false;
	}
}
