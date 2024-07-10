package edu.example;

import java.util.Arrays;

public class Example1 {

	/**
	 * 1
	 * 정수 2개를 인자로 받아서 첫번째 인자가 두번째 인자보다 2이상 크면 true를, 아니면 false를 반환하는 method를 만드시오.
	 * (입력은 공백으로 구분)
	 */
	public boolean q1(int n, int m) {
		return (n - m) >= 2; // 첫번째 인자 - 두번째 인자
	}

	/**
	 * 2
	 * 하나의 String을 인자로 받아서 문자열 안에 영문 소문자 "a"라는 문자가 몇 개 있는지 출력하고,
	 * 한 단어에 "a"가 2개 이상 들어있으면 true를 아니면 false를 반환하는 method를 만드시오.(for 사용)
	 */
	public boolean q2(String str) {
		int aCnt = 0; // a의 갯수
		for (int i = 0; i < str.length(); i++) {
			if ('a' == (str.charAt(i))) { // string -> char[], ASCII CODE 97
				aCnt++;
			}
		}
		System.out.printf("a 갯수 : %d\n", aCnt);
		return aCnt >= 2;
	}

	/**
	 * 3
	 * 크기가 10인 1차원 배열을 만들고 숫자 10개를 인자로 받아 배열에 담고 그 배열의 값들을 역순으로 출력하는 method를 만드시오.
	 * (입력은 공백으로 구분)
	 */
	public int[] q3(int[] numArr) {
		for (int i = 0; i < (numArr.length / 2); i++) {
			int tmp = numArr[i];
			numArr[i] = numArr[numArr.length - i - 1];
			numArr[numArr.length - i - 1] = tmp;
		}
		return numArr;
	}

	/**
	 * 4
	 * 공백을 구분자로 하는 일련의 숫자를 인자로 받아서 배열에 담고 배열의 5번째까지의 인자중에 4가 있으면 true를 아니면 false를 리턴하는 method를 만드시오.
	 * (for 사용, 인자의 갯수는 제한 없음)
	 */
	public boolean q4(String str) throws NumberFormatException {
		String[] split = str.split("\\s"); // 공백 기준 문자 split
		int[] numArr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray(); // string[] -> int[]
		for (int i = 0; i < 5; i++) {
			if (numArr[i] == 4) { // 값이 4일때
				return true;
			}
		}
		return false;
	}

	/**
	 * 5
	 * 공백을 구분자로 하는 일련의 숫자를 인자로 받아서 배열에 담고 내림차순으로 정렬하여 리턴하는 method를 만드시오.
	 * (for 사용, 인자의 갯수는 제한 없음)
	 */
	public int[] q5(String str) {
		String[] split = str.split("\\s"); // 공백 기준 문자 split
		int[] numArr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray(); // String[] -> int[]
		int tmp = 0;
		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] < numArr[j]) { // 값 비교해서 요소 위치 변경
					tmp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = tmp;
				}
			}
		}
		return numArr;
	}

	/**
	 * 6
	 * 공백을 구분자로 하는 일련의 숫자를 인자로 받아서 배열에 담고 오름차순으로 정렬하여 리턴하는 method를 만드시오.
	 * (for 사용, 인자의 갯수는 제한 없음)
	 */
	public int[] q6(String str) {
		String[] split = str.split("\\s"); // 공백 기준 문자 split
		int[] numArr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray(); // String[] -> int[]
		int tmp = 0;
		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] > numArr[j]) { // 값 비교해서 요소 위치 변경
					tmp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = tmp;
				}
			}
		}
		return numArr;
	}

	/**
	 * 7
	 * 임의의 문자열을 입력받아서 문자열 안에 소문자 "xx"가 몇 번 나오는지 출력하는 method를 만드시오.
	 * 단 "xxx"는 "xx"가 2번 있는것으로 간주함(중복 카운트 가능, for 사용, 인자의 갯수는 제한 없음)
	 */
	public int q7(String str) {
		int xxCnt = 0;
		char[] cArr = str.toCharArray(); // String -> char[]
		for (int i = 0; i < cArr.length - 1; i++) {
			if (cArr[i] == 'x' && cArr[i + 1] == 'x') { // ASCII CODE 값 비교
				xxCnt++;
			}
		}
		return xxCnt;
	}
}
