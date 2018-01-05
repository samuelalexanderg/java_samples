package math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
	public static void main(String[] args) {
//		int randomCo = ThreadLocalRandom.current().nextInt(699, 720 + 1);
//		System.out.println(randomCo);
////		System.out.println((float) ((float)randomCo / (float)1000));
//		System.out.println( (40 + ((float) randomCo / (float) 1000)));

		int randomCo = ThreadLocalRandom.current().nextInt(-969, -747);
		System.out.println(-(73 - ((float) randomCo / (float) 1000)));
//		Random random = new Random(1);
//		for (int i = 0; i < 100; i++) {
//			System.out.println(random.nextInt());
//		}
	}
}
