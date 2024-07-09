package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class codingTest {

	/**
	 *
	문제 : 최빈값 : 주어진 값 중 가장 자주 나오는 값
	정수 배열 array가 매개변수로 주어질 때,
	최빈값을 return 하도록 solution 함수를 완성해보세요.
	최빈값이 여러 개면 -1을 return 합니다.
	[제한사항]
	1. 0 < array의 길이 < 100
	2. 0 ≤ array의 원소 < 1000
	 * @param array
	 * @return
	 */
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

	/**
	 *
	힘이나는 커피는 아이스아메리카노를 시켜먹으면 한 잔당 쿠폰을 한 장 발급합니다.
	쿠폰을 열 장 모으면 아이스아메리카노를 1잔 서비스로 받을 수 있고, 서비스 에도 쿠폰이 발급됩니다.
	시켜먹은 아아의 수 coffee가 매개변수로 주어질 때 받을 수 있는 최대 서비스 아아의 수를 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	1. coffee는 정수입니다.
	2. 0 ≤ coffee ≤ 1,000,000
	 * @param coffee
	 * @return
	 */
	public int solution2(int coffee) {
		int answer = -1;
		answer = coffee / 9;
		if (coffee > 1 && coffee % 9 == 0) {
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

	public static void main(String[] args) {

		codingTest main = new codingTest();

		int[] test1 = {1, 4, 3, 4, 8};
//		System.out.println(main.solution1(test1));	//최빈값 구하기

		int test2 = 89;
//		System.out.println(main.solution2(test2));	//증감, 몫

		int[][] test3 = { { 100, 70 }, { 100, 100 }, { 100, 100 } };
//		System.out.println(main.solution3(test3));	//2차원 배열

		String test4 = "zerothree";
//		System.out.println(main.solution4(test4));

		int[] test5 = {100,17,84,1};
		int[] test6 = {55,12,65,36};
//		System.out.println(main.solution5(test5, test6));

		int[] test7 = { 10, 2 , 3, 2, 55};
//		System.out.println(Arrays.toString((main.solution7(test7))));

		String test8 = "bassSY";
//		System.out.println(main.solution8(test8));

		String test9 = "Zakeidk";
//		System.out.println(main.solution9(test9));

		String test10 = "-1 -2 3 4";
//		System.out.println(main.solution10(test10));

 	}

}
