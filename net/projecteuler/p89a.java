package net.projecteuler;

/*
Converts Roman Numerals
*/

import java.io.*;
import java.util.Scanner;

public class p89a {
   
   
   public static String westernToRoman(int western) {
   	int level=7;
   	String roman = "";
   	while(level>0) {
   		if(western - levelToValue(level)>=0) {
   			roman += String.valueOf(levelToNumeral(level));
   			western -= levelToValue(level);
   		} else {
   			//Check to see if you should use subtraction
   			int subtractorLevel = (int)Math.floor(level/2)*2-1;
   			if(subtractorLevel>0 && western-(levelToValue(level)-levelToValue(subtractorLevel))>=0) {
   				western -= (levelToValue(level)-levelToValue(subtractorLevel));
   				roman = roman + levelToNumeral(subtractorLevel) + levelToNumeral(level);
   			}
   			level--;
   				
   		}
   	}
   	return roman;
   }
   
   public static int romanToWestern(String roman) {
   	
   	int western = 0; //the numerical version
   	char currentChar;
   	char nextChar;
   	
   	int i=0;
   	
   	while(i<roman.length()) {
   		currentChar = roman.charAt(i);
   		if(i<roman.length()-1) {
   			nextChar = roman.charAt(i+1);
   			if(getValue(currentChar)<getValue(nextChar)) {
   				western += (getValue(nextChar) - getValue(currentChar));
   				i+=2;
   			} else {
   				western += getValue(currentChar);
   				i++;
   			}
   		} else {
   			western += getValue(currentChar);
   			i++;
   		}
   	}
   	return western;
   	
   }
   
   private static int getValue(char l) { //Converts the numeral to a number
   	String letter = String.valueOf(l);
   	if(letter.equalsIgnoreCase("I")) return 1;
   	if(letter.equalsIgnoreCase("V")) return 5;
   	if(letter.equalsIgnoreCase("X")) return 10;
   	if(letter.equalsIgnoreCase("L")) return 50;
   	if(letter.equalsIgnoreCase("C")) return 100;
   	if(letter.equalsIgnoreCase("D")) return 500;
   	if(letter.equalsIgnoreCase("M")) return 1000;
   	return 0;
   }
   
   private static char levelToNumeral(int level) {
   	String character;
   	if(level == 1)
   		character = "I";
   	else if(level == 2)
   		character = "V";
   	else if(level == 3)
   		character = "X";
   	else if(level == 4)
   		character = "L";
   	else if(level == 5)
   		character = "C";
   	else if(level == 6)
   		character = "D";
   	else if (level == 7)
   		character = "M";
   	else
   		character = "E";
   	return character.charAt(0);
   }
   
   private static int levelToValue(int level) {
   	if(level == 1)
   		return 1;
   	if(level == 2)
   		return 5;
   	if(level == 3)
   		return 10;
   	if(level == 4)
   		return 50;
   	if(level == 5)
   		return 100;
   	if(level == 6)
   		return 500;
   	if(level == 7)
   		return 1000;
   	//error
   	System.out.println("Error in the getLevel sub. level = " + level);
   	return 1;
   }
   
   public static void main(String[] args) throws FileNotFoundException  {
   	
   	String[] numerals = new String[1000];
   	int charactersBefore=0;
   	int charactersAfter=0;
   	
   	//Read the txt file:
   	File fFile = new File("E:/Administrator's Documents/temp/roman.txt");
   	Scanner scanner = new Scanner(fFile);
   	int i=0;
   	while ( scanner.hasNextLine() ){
       	numerals[i] = scanner.nextLine();
       	i++;
   	}
   	
   	String simplified;
   	
   	//Calculate "charactersBefore" and then simplify the numerals
   	for (i=0; i<1000; i++) {
   		charactersBefore += numerals[i].length();
   		int western = p89a.romanToWestern(numerals[i]);
   		String roman = p89a.westernToRoman(western);
   		charactersAfter += roman.length();
   		//System.out.println(numerals[i] + " becomes " + western + " which becomes " + roman);
   		System.out.println(roman);
   	}
   	
   	System.out.println("We gained " + (charactersBefore - charactersAfter) + " characters");
   }
}