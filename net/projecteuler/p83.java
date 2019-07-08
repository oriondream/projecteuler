package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class p83 {
	
	int[][] a = {
			{131,673,234,103,18},
			{201,96,342,965,150},
			{630,803,746,422,111},
			{537,699,497,121,956},
			{805,732,524,37,331}};
	
	public int findMin(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] min = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				min[r][c] = Integer.MAX_VALUE/2;
				visited[r][c] = false;
			}
		}
		
		min[0][0] = matrix[0][0];

		boolean done = false;
		while (!done) {
			int choiceValue = Integer.MAX_VALUE;
			int choiceR = 0;
			int choiceC = 0;
			done = true;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (!visited[r][c] && min[r][c] < choiceValue) {
						choiceValue = min[r][c];
						choiceR = r;
						choiceC = c;
						done = false;
					}
				}
			}
			if (!done) {
				visited[choiceR][choiceC] = true;
				int[] dr = {0, 1, 0, -1};
				int[] dc = {-1, 0, 1, 0};
				for (int i = 0; i < 4; i++)
					if (0 <= choiceR + dr[i] && choiceR + dr[i] < row 
							&& 0 <= choiceC + dc[i] && choiceC + dc[i] < col 
							&& min[choiceR][choiceC] + matrix[choiceR+dr[i]][choiceC+dc[i]] < min[choiceR+dr[i]][choiceC+dc[i]]) {
						min[choiceR+dr[i]][choiceC+dc[i]] = min[choiceR][choiceC] + matrix[choiceR+dr[i]][choiceC+dc[i]];
					}
			}
		}

		return min[row-1][col-1];
	}
		
	public p83() {
		System.out.println(findMin(a));
		//System.exit(0);
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
		new p83();
	}

}
