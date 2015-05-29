package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count30 {
	public static void main(String[] args) {
		List<Integer> num1 = Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15});
		List<Integer> num2 = Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15});
		List<Integer> num3 = Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15});
		List<Integer> num4 = Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15});
		List<Integer> num5 = Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 11, 13, 15});
		
		
		for (Integer int1 : num1) {
			for (Integer int2 : num2) {
				for (Integer int3 : num3) {
					for (Integer int4 : num4) {
						for (Integer int5 : num5) {
							System.out.println(int1);
							System.out.println(int2);
							System.out.println(int3);
							System.out.println(int4);
							System.out.println(int5);
							System.out.println((int1 + int2 + int3 + int4 + int5));
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						} 
					}
				}
			}
		}
	}
}
