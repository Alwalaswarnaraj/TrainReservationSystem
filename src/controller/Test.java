package controller;

import java.util.Scanner;

public class Test {
	int ac;
	{
		Scanner sc = new Scanner(System.in);
		ac = sc.nextInt();
//		System.out.println(ac);
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.ac);
	}
}
