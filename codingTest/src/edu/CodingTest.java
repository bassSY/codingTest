package edu;

import edu.example.Example4;
import edu.example.Example5;

public class CodingTest {

	public static void main(String[] args) {

		Example4 example4 = new Example4();
		Example5 example5 = new Example5();

		int[] test1 = {1, 4, 3, 4, 8};
//		System.out.println(example4.solution1(test1));	//최빈값 구하기

		int test2 = 1081;
//		System.out.println(example4.solution2(test2));	//증감, 몫

		int[][] test3 = { { 100, 70 }, { 100, 100 }, { 100, 100 } };
//		System.out.println(example4.solution3(test3));	//2차원 배열

		String test4 = "zerothree";
//		System.out.println(example4.solution4(test4));

		int[] test5 = {100,17,84,1};
		int[] test6 = {55,12,65,36};
//		System.out.println(example4.solution5(test5, test6));

		int[] test7 = { 10, 2 , 3, 2, 55};
//		System.out.println(Arrays.toString((example5.solution7(test7))));

		String test8 = "bassSY";
//		System.out.println(example5.solution8(test8));

		String test9 = "Zakeidk";
//		System.out.println(example5.solution9(test9));

		String test10 = "-1 -2 3 4";
//		System.out.println(example5.solution10(test10));

 	}

}
