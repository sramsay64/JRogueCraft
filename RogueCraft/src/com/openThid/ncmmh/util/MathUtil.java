package com.openThid.ncmmh.util;

public class MathUtil {
	public static int sum(int[] numbers) {
		int acc = 0;
		for (int i = 0; i < numbers.length; i++) {
			acc += numbers[i];
		}
		return acc;
	}
}