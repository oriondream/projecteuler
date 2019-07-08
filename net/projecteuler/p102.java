package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Point {
	public double x,y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

/**
 * One can use Heron formula
 * @author Administrator
 *
 */
public class p102 {
    static double ccw(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
    }

    static double area(Point p1, Point p2, Point p3) {
    	return Math.abs((p1.x-p2.x)*(p1.y+p2.y) + (p2.x-p3.x)*(p2.y+p3.y) + (p3.x-p1.x)*(p3.y+p1.y))/2;
    }
    
	static Point O = new Point(0,0); 

    static boolean containO(Point A, Point B, Point C) {
    	if (ccw(O,A,B)*ccw(O,B,C) > 0 && ccw(O,B,C)*ccw(O,C,A) > 0)
    	//if (area(A,O,B) + area(B,O,C) + area(C,O,A) == area(A,B,C)) 	// using the area formula
    		return true;
    	else
    		return false;
    }
    
	public static void main(String[] args) {
		System.out.println(area(new Point(1,1),new Point(2,2), new Point(3,4)));

		int count = 0;
		
		try {
			FileReader fr = new FileReader("E:/Administrator's Documents/temp/triangles.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				Point A = new Point(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
				Point B = new Point(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
				Point C = new Point(Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]));
				
				if (containO(B,C,A)) {
					++count;
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		
		System.out.println(count);
	}
}
