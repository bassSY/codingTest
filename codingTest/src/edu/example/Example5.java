package edu.example;

import java.util.Arrays;
import java.util.Collections;

public class Example5 {

	public int[] solution7(int[] arr) {

		// 배열 길이가 1인 경우 -1 반환
		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}
		// 배열길이가 1보다 클 때 가장 작은 수를 뺀 길이의 배열로
		int[] answer = new int[arr.length - 1];

		int min = arr[0];

		// 가장 작은 수 구하기
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}

		int index = 0; // 반복문용 변수. 가장 작은 수가 여러개 일 수 있기 때문에 사용

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) {
				//continue for문으로 올라감
				continue;
			}
			answer[index++] = arr[i];
		}
		return answer;
	}

	public String solution8(String new_id) {
		String answer = "";
		String temp = new_id.toLowerCase();
		temp = temp.replaceAll("[^-_.a-z0-9]", "");
		// System.out.println(temp);
		temp = temp.replaceAll("[.]{2,}", ".");
		temp = temp.replaceAll("^[.]|[.]$", "");
		// System.out.println(temp.length());
		if (temp.equals(""))
			temp += "a";
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

	public String solution9(String s) {
		String answer = "";
		String[] str = s.split("");
//		System.out.println(Arrays.toString(str));
		Arrays.sort(str, Collections.reverseOrder());

		for (String a : str) {
			answer += a;
		}
		return answer;
	}

	public String solution10(String s) {
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
