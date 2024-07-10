package edu.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2Run {

	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		Example2 example2 = new Example2();
		boolean isRun = true;

		while (isRun) {
            System.out.print("문제 번호 입력 (1~7) > ");
            try {
                switch (sc.nextInt()) {
                    case 1:
                        inputGuide();
                        System.out.println(example2.q1(sc.nextLine()));
                        break;
                    case 2:
                        inputGuide();
                        System.out.printf("갯수: %d\n", example2.q2(sc.nextLine()));
                        break;
                    case 3:
                        inputGuide();
                        System.out.printf("갯수: %d\n", example2.q3(sc.nextLine()));
                        break;
                    case 4:
                        inputGuide();
                        System.out.printf("index: %d\n", example2.q4(sc.nextLine()));
                        break;
                    case 5:
                        inputGuide();
                        System.out.printf("index: %d\n", example2.q5(sc.nextLine()));
                        break;
                    case 6:
                        inputGuide();
                        System.out.printf("index: %d\n", example2.q6(sc.nextLine()));
                        break;
                    case 7:
                        inputGuide();
                        example2.q7(sc.nextLine());
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

	public static void inputGuide() {
        System.out.print("문장 입력 > ");
        sc.nextLine();
    }

}
