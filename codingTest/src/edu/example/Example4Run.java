package edu.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example4Run {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Example4 example4 = new Example4();

		boolean isRun = true;
		while (isRun) {
			System.out.print("문제 번호 입력 (1~5) > ");
			try {
				switch (sc.nextInt()) {
				case 1:
					System.out.print("숫자 배열 입력 > ");
					// nextInt() 입력 후 엔터를 누르면 개행문자(엔터)가 nextLine()으로 넘어가 NumberFormatException을
					// 방지하는역할
					sc.nextLine();
					System.out.println(example4.solution1(sc.nextLine()));
					break;
				case 2:
					System.out.println("몇 마리 시켰나요 > ");
					System.out.println(example4.solution2(sc.nextInt()));
					break;
				case 3:
					System.out.print("학생이 몇명인가요 > ");
					int rows = sc.nextInt();
					int cols = 2; // 국어, 코딩점수

					int[][] test3 = new int[rows][cols];

					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							if (j == 0) {
								System.out.print("국어 점수를 입력하세요 > ");
							} else if (j == 1) {
								System.out.print("코딩 점수를 입력하세요 > ");
							}
							test3[i][j] = sc.nextInt();
						}
					}

					System.out.println("::::::::::입력한 점수는:::::::::");
					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							System.out.print(j == 0 ? "국어점수::" + test3[i][j] + " " : "코딩점수::" + test3[i][j] + " ");
						}
						System.out.println();
					}

					System.out.println(example4.solution3(test3)); // 2차원 배열
					break;
				case 4:
					System.out.print("문자열 입력 > ");
					System.out.println(example4.solution4(sc.next()));
					break;
				case 5:
					int count = 0;
					int[] test5;
					int[] test6;
					System.out.print("첫번째 배열에 넣을 개수 > ");
					count = sc.nextInt();
					test5 = new int[count];
					System.out.println(count + "개의 숫자를 입력하시오.");
					for (int i = 0; i < count; i++) {
						test5[i] = sc.nextInt();
					}
					System.out.println("두번째 배열에 넣을 개수 >");
					count = sc.nextInt();
					test6 = new int[count];
					System.out.println(count + "개의 숫자를 입력하시오");
					for (int i = 0; i < count; i++) {
						test6[i] = sc.nextInt();
					}

					System.out.println(example4.solution5(test5, test6));
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
