package edu.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Example1 example1 = new Example1();

		boolean isRun = true;
		boolean answer;

		while(isRun) {
			System.out.print("문제 번호 선택 > ");
			try {
				switch (sc.nextInt()) {
				case 1 :
					System.out.print("정수 2개 입력 > ");
					answer = example1.q1(sc.nextInt(), sc.nextInt());
					System.out.println(answer);
					break;
				case 2 :
					System.out.print("문자열 입력 > ");
					answer = example1.q2(sc.next());
					System.out.println(answer);
					break;
				case 3:
					System.out.print("10개의 숫자 배열 입력 > ");
					int[] numArr = new int[10]; // 크기가 10인 배열 생성
					for (int i = 0; i < numArr.length; i++) {
						numArr[i] = sc.nextInt();
					}
					int[] a3 = example1.q3(numArr);
					System.out.println(Arrays.toString(a3));
					break;
				case 4:
					System.out.print("숫자 배열 입력 > ");
					sc.nextLine(); // nextInt() 입력 후 엔터를 누르면 개행문자(엔터)가 nextLine()으로 넘어가 NumberFormatException을 방지하는 역할
					answer = example1.q4(sc.nextLine());
					System.out.println(answer);
					break;
				case 5:
					System.out.print("숫자 배열 입력 > ");
					sc.nextLine();
					int[] a5 = example1.q5(sc.nextLine());
					System.out.println(Arrays.toString(a5));
					break;
				case 6:
					System.out.print("숫자 배열 입력 > ");
					sc.nextLine();
					int[] a6 = example1.q6(sc.nextLine());
					System.out.println(Arrays.toString(a6));
					break;
				case 7:
					System.out.print("문자열 입력 > ");
					int a7 = example1.q7(sc.next());
					System.out.println(a7);
					break;
				default:
					isRun = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("입력 값 확인 후 다시 작성!");
				sc = new Scanner(System.in);
			} catch (NumberFormatException e) {
				System.out.println("정수만 입력 가능!");
				sc = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println("관리자 문의!");
				sc = new Scanner(System.in);
			}
		}
	}

}
