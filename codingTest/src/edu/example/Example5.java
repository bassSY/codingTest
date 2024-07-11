package edu.example;

import java.util.Arrays;
import java.util.Collections;

public class Example5 {

	public int[] solution1(String str) throws NumberFormatException {
		String[] split = str.split("\\s"); // 공백 기준 문자 split
		int[] numArr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray(); // string[] -> int[]

		// 배열 길이가 1인 경우 -1 반환
		if (numArr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}
		int min = Arrays.stream(numArr).min().getAsInt();
		return Arrays.stream(numArr).filter(i -> i != min).toArray();
	}

	public int[] solution1Temp(String str) throws NumberFormatException {
		String[] split = str.split("\\s"); // 공백 기준 문자 split
		int[] numArr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray(); // string[] -> int[]

		if (numArr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}

		int[] answer = new int[numArr.length - 1];
		int minIndex = 0;

		for (int i = 0; i < numArr.length; i++) {
			if (numArr[minIndex] > numArr[i]) {
				minIndex = i;
			}
		}
		for (int i = minIndex + 1; i < numArr.length; i++) {
			numArr[i - 1] = numArr[i];
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = numArr[i];
		}

		return answer;
	}

	public String solution2(String new_id) {
		String answer = "";
		String temp = new_id.toLowerCase();
		temp = temp.replaceAll("[^-_.a-z0-9]", "");
		// System.out.println(temp);
		temp = temp.replaceAll("[.]{2,}", ".");
		temp = temp.replaceAll("^[.]|[.]$", "");
		// System.out.println(temp.length());
		if (temp.equals("")) {
			temp += "a";
		}
		if (temp.length() >= 16) {
			temp = temp.substring(0, 15);
			temp = temp.replaceAll("^[.]|[.]$", "");
		}

		if (temp.length() <= 2) {
			while (temp.length() < 3) {
				temp += temp.charAt(temp.length() - 1);
			}
		}
		answer = temp;

		return answer;
	}

	public String solution3(String s) {
		String answer = "";
		String[] str = s.split("");
//		System.out.println(Arrays.toString(str));
		Arrays.sort(str, Collections.reverseOrder());

		for (String a : str) {
			answer += a;
		}
		return answer;
	}

	public String solution4(String s) {
		String answer = "";
		String[] numbers = s.split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.length; i++) {
			int number = Integer.parseInt(numbers[i]);

			min = Math.min(min, number);

			max = Math.max(max, number);
		}

		answer = min + " " + max;
		return answer;
	}
}
