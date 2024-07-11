package edu.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example5Run {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Example5 example5 = new Example5();
		boolean isRun = true;
		while (isRun) {
			System.out.print("문제 번호 입력 (1~4) > ");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.print("숫자 배열 입력 > ");
					sc.nextLine();
					System.out.println(Arrays.toString((example5.solution1(sc.nextLine()))));
//					System.out.println(Arrays.toString((example5.solution1Temp(sc.nextLine()))));
					break;
				case 2:
					System.out.print("문자열 입력 > ");
					System.out.println(example5.solution2(sc.next()));
					break;
				case 3:
					System.out.print("문자열 입력 > ");
					System.out.println(example5.solution3(sc.next()));
					break;
				case 4:
					System.out.print("숫자 배열 입력 > ");
					sc.nextLine();
					System.out.println(example5.solution4(sc.nextLine()));
					break;
				default:
					System.out.println("비정상 입력 종료");
					isRun = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("입력 값 확인!");
				e.printStackTrace();
				sc = new Scanner(System.in);
			} catch (NullPointerException e) {
				System.out.println("값이 비어있음!");
				e.printStackTrace();
				sc = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("관리자 문의!");
				e.printStackTrace();
				sc = new Scanner(System.in);
			}
		}
	}

}
