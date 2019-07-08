package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class p81 {
	
	int[][] a = {{131,673,234,103,18},
	{201,96,342,965,150},
	{630,803,746,422,111},
	{537,699,497,121,956},
	{805,732,524,37,331}};
	
	public int findMin(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] min = new int[row][col];
		
		min[0][0] = matrix[0][0];
		
		for (int i = 1; i < row; i++) {
			min[i][0] = min[i-1][0] + matrix[i][0];
		}
		
		for (int i = 1; i < col; i++) {
			min[0][i] = min[0][i-1] + matrix[0][i];
		}
		
		for (int i= 1; i < row; i++)
			for (int j = 1; j < col; j++)
				min[i][j] = Math.min(min[i-1][j], min[i][j-1]) + matrix[i][j];
		
		return min[row-1][col-1];
	}
		
	public p81() {
		int[][] matrix = new int[80][80];
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/temp/matrix.txt"));
			for (int i = 0; i < 80; i++) {
				String str = br.readLine();
				String[] strNumbers = str.split(",");  
				for (int j = 0; j < 80; j++) {
					matrix[i][j] = Integer.parseInt(strNumbers[j]); 
				}
			}
			
			System.out.println(findMin(a));
			System.out.println(findMin(matrix));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p81();
	}

}
