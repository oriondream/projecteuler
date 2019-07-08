package net.projecteuler;

 import java.util.Arrays;
 
/**
 * Trau bo huc 
 * @author Administrator
 *
 */
public class p112 {
 
	public static void main(String args[])
	{
		int count=0;
	for(int i=1; i<30000000;i++)
	{
		String test=Integer.toString(i);
		if(!sortA(test).equals(test))
		{
			if(!sortD(test).equals(test))
			{
				count++;
			}
		}
		if((double) count/i*100 ==99.0)
		{
			System.out.println(i);
			break;
		}
	}
	}
 
	public static String sortA(String h)
	{
	String hey="";
 
	char[] aman= h.toCharArray();
 
	Arrays.sort(aman);
 
	for(int i=0; i<aman.length;i++)
	{
		hey=hey+aman[i];
	}
	return hey;
	}
	public static String sortD(String h)
	{
	String hey="";
 
	char[] aman= h.toCharArray();
 
	Arrays.sort(aman);
	aman=reverse(aman);
 
	for(int i=0; i<aman.length;i++)
	{
		hey=hey+aman[i];
	}
	return hey;
	}
	public static char[] reverse(char[] a)
	{
		int l=a.length;
		char[] rev= new char[l];
		for(int i=0; i<l; i++)
		{
			rev[i]=a[l-i-1];
		}
		return rev;
	}
 
}