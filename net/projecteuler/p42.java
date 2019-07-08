package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class p42 {
	int getValue(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += (byte) str.charAt(i) - (byte) 'A' + 1; 
		}
		return sum;
	}
	
	static boolean[] isTriangle = new boolean[10000];
	static {
		for (int n = 1; n*(n+1)/2 < isTriangle.length; n++) {
			isTriangle[n*(n+1)/2] = true;
		}
	}
	
	public p42() {
		try {
			System.out.println(getValue("SKY"));
			System.out.println(isTriangle[35]);
			System.out.println(isTriangle[36]);
			System.out.println(isTriangle[37]);
			BufferedReader in = new BufferedReader(new FileReader("C:/temp/words.txt"));
			String str = null;
			int count = 0;
			str = in.readLine();
			String[] words = str.split(",");
			for (int i = 0; i < words.length;i++) {
				String s = words[i].substring(1, words[i].length() - 1);
				if (isTriangle[getValue(s)]) {
					++count;
				}
				System.out.println(s);
			}
			System.out.println(count);
			System.exit(0);
		}
		catch (IOException o) {
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p42();
	}
}
