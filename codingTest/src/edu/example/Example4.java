package edu.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example4 {

	public int solution1(int[] array) {
		int answer = 0;
		int maxCount = 0;

		Map<Integer, Integer> map = new HashMap<>();
		// getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
		if (array.length < 100) {
			for (int number : array) {
				if (number <= 1000) {
					int count = map.getOrDefault(number, 0) + 1;
					if (count > maxCount) {
						maxCount = count;
						answer = number;
					} else if (count == maxCount) {
						answer = -1;
					}
					// System.out.println("num::" + number);
					// System.out.println("count::" + count);
					map.put(number, count);
				} else {
					answer = 0;
					break;
				}

			}
		} else {
			answer = 0;
		}
		return answer;
	}

	public int solution2(int chicken) {
		int answer = -1;
		answer = chicken / 9;
		if (chicken > 1 && chicken % 9 == 0) {
			answer--;
		}

		return answer;
	}

	public String solution3(int[][] score) {
		int[] answer = {};
		List<Integer> scoreList = new ArrayList<>();
		boolean flag = true;
		for (int[] t : score) {
			if (t[0] >= 0 && t[0] <= 100 && t[1] >= 0 && t[1] <= 100) {
				scoreList.add(t[0] + t[1]);
			} else {
				flag = false;
			}
		}

		if (!flag) {
			return "점수는 0이상 100이하 값 입니다.";
		}

		scoreList.sort(Comparator.reverseOrder());

		answer = new int[score.length];

		for (int i = 0; i < score.length; i++) {
			answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
		}
		return Arrays.toString(answer);
	}

	public long solution4(String numbers) {
		long answer = 0;
		String[] numbers_arr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < numbers_arr.length; i++) {
			numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
		}
		// 0으로 시작 못하게
		answer = Long.parseLong(numbers);
		return answer;
	}

	public int solution5(int[] arr1, int[] arr2) {
		int answer = 0;

		if(arr1.length != arr2.length) {
			answer = arr1.length > arr2.length ? 1 : -1;
		} else {
			int arr1Sum = 0;
			int arr2Sum = 0;
			for(int a : arr1) {
				arr1Sum += a;
			}
			for (int b : arr2) {
				arr2Sum += b;
			}

			if(arr1Sum != arr2Sum) {
				answer = arr1Sum > arr2Sum ? 1 : -1;
			}else {
				answer = 0;
			}
		}
		return answer;
	}
}
