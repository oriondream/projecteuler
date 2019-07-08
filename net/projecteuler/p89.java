package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p89 {
	static int[] value = new int[255];
	static {
		value['I'] = 1;
		value['V'] = 5;
		value['X'] = 10;
		value['L'] = 50;
		value['C'] = 100;
		value['D'] = 500;
		value['M'] = 1000;
	}
	static final int MAX = 5000;
	String[] cost = new String[MAX+1];
	int[] head = new int[MAX+1];
	int[] tail = new int[MAX+1];
	
	void initPair(char i, char j) {
		if (cost[value[j] - value[i]] == null) {
			cost[value[j] - value[i]] = i + "" + j;
			head[value[j] - value[i]] = value[j];
			tail[value[j] - value[i]] = value[j];
		}
	}
	
	void initCost() {		
		String[] basicChar = {"I", "V", "X", "L", "C", "D", "M"};
		int[] basicValue = {1, 5, 10, 50, 100, 500, 1000};

		for (int i = 0; i < basicValue.length; i++) {
			head[basicValue[i]] = basicValue[i];
			cost[basicValue[i]] = basicChar[i];
			tail[basicValue[i]] = basicValue[i];

			head[basicValue[i] + basicValue[i]] = basicValue[i];
			cost[basicValue[i] + basicValue[i]] = basicChar[i] + basicChar[i];
			tail[basicValue[i] + basicValue[i]] = basicValue[i];
		}
		
		initPair('I','V');
		initPair('I','X');
		initPair('X','L');
		initPair('X','C');
		initPair('C','D');
		initPair('C','M');
		
		for (int i = 0; i < basicChar.length-1; i++)
			for (int j = 0; j <= i; j++)
				if (cost[basicValue[j] + basicValue[i]] == null) {
					cost[basicValue[j] + basicValue[i]] = basicChar[i] + basicChar[j];
					head[basicValue[j] + basicValue[i]] = basicValue[i];
					tail[basicValue[j] + basicValue[i]] = basicValue[j];
				}

		for (int length = 3; length <= 15; length++)
			for (int headLength = 1; headLength < length; headLength++) {
				int tailLength = length - headLength;
				for (int i = 1; i <= MAX; i++)
					if (cost[i] != null && cost[i].length() == headLength)
						for (int j = 1; j <= MAX; j++)
							if (cost[j] != null && cost[j].length() == tailLength && tail[i] >= head[j] && i+j <= MAX && (cost[i+j] == null || cost[i+j].length() > length)) {
								cost[i+j] = cost[i] + cost[j];
								tail[i+j] = tail[j];
								head[i+j] = head[i];
							}
			}
	}
	/**
	 * COMPUTE the decimal number
	 * 
	 * - Init previous value to 0
	 * - Travel from the left to the right
	 * - if current digit < value
	 * -     add value to the sum
	 * -     value = 0
	 * - else 
	 * -     add current digit substract value to the sum 
	 */
	int readRoman(String str) {
		int i = 0;
		int sum = 0;
		while (i+1 < str.length()) {
			if (value[str.charAt(i)] < value[str.charAt(i+1)]) {
				sum += value[str.charAt(i+1)] - value[str.charAt(i)];
				i += 2;
			}
			else {
				sum += value[str.charAt(i)];
				i += 1;
			}			
		}
		if (i < str.length()) {
			sum += value[str.charAt(i)];
		}
		return sum;
	}
	
	String fileName = "E:/Administrator's Documents/temp/roman.txt";
	public p89() {
/*		System.out.println(readRoman("IXIX"));
		System.exit(0);
*/		

		initCost();
		
/*		for (int i = 1; i <= MAX; i++) {
			System.out.println(cost[i]);
			int check = readRoman(cost[i]);
			if (check != i)
				System.err.println("Error");
		}
*/		//System.exit(0);
		
		try {
			BufferedReader isr = new BufferedReader(new FileReader(fileName));
			String str;
			int sum = 0;
			while ((str = isr.readLine()) != null) {
				int value = readRoman(str);
				if (cost[value] != null) 
					sum += str.length() - cost[value].length();
				else 
					System.err.println("Number " + value + " is not calculated");
				//System.out.println(str+" becomes "+value+" which becomes "+cost[value]);
				System.out.println(cost[value]);
			}
			System.out.println("Characters saved: " + sum);
		}
		catch (IOException e) {
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p89();
		/**
		 * 1. Open file to read number
		 * 2. while not eof do
		 * 3.     read a line
		 * 4.     convert to normal number
		 * 5.     compute the new roman string
		 * 6.     compute the new length
		 * 7.     add the difference to the sum
		 * 8. end
		 * 9. print out the sum
		 */
		/**
		 * COMPUTE the optimal Roman 
		 * 
		 * - Initialize the cost array
		 * - Compute the optimal cost using cost array
		 */
	}
}
