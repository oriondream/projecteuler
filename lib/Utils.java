package lib;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {
	/**
	 * Calculate the pentagon number
	 * @return
	 */
	public static long pentagon(int n) {
		return n*(3*n-1)/2;
	}
	public static BigInteger reverse(BigInteger N) {
		String str = N.toString();
		String res = "";
		for (int i = 0; i < str.length(); i++)
			res = str.charAt(i) + res;
		return new BigInteger(res);
	}
	public static boolean isPalindrom(BigInteger N) {
		String str = N.toString();
		int i = 0;
		int j = str.length() - 1;
		
		while (i <= j && str.charAt(i) == str.charAt(j)) {
			++i;
			--j;
		}
		
		return (i > j);
	}
	public static boolean isPalindrom(Long N) {
		String str = N.toString();
		int i = 0;
		int j = str.length() - 1;
		
		while (i <= j && str.charAt(i++) == str.charAt(j--));
		
		return (i > j);
	}
	public static boolean isSpanDigital(long N) {
		long[] count = new long[10];
		while (N != 0) {
			++count[(int)(N%10)];
			N /= 10;
		}
		if (count[0] != 0) 
			return false;
		for (int i = 1; i <= 9; i++) {
			if (count[i] != 1)
				for (int j = i; j <= 9; j++)
					if (count[j] != 0)
						return false;
		}
		return true;
	}
	
	public static boolean[] erathosten = new boolean[2000000];
	
	public static int[] primes = null;
	
	static {
		for (int i = 2; i < erathosten.length; i++)
			erathosten[i] = true;
		
		int count = 0;
		
		for (int i = 2; i < erathosten.length; i++) 
			if (erathosten[i]) {
				++count;
				int maxj = (erathosten.length-1)/i;
				for (int j = 2; j <= maxj; j++)
					erathosten[i*j] = false;
			}
		
		primes = new int[count];
		
		count = 0;
		
		for (int i = 2; i < erathosten.length; i++) 
			if (erathosten[i]) {
				primes[count++] = i;
			}
	}
	
	public static boolean isPrime(long N) {
		if (N < erathosten.length) {
			return erathosten[(int) N];
		}
		else {
			for (int k = 2; k < Math.sqrt(N); k++)
				if (N%k == 0)
					return false;
			
			return true;
		}
	}
	public static long factorial(int N) {
		if (N <= 1)
			return 1;
		
		long result = 1;
		
		for (long i = 1; i <= N; i++)
			result *= i;
		
		return result;
	}
	public static int[] digits(final long N) {
		long t = N;
		int count = 0;
		while (t > 0) {
			++ count;
			t /= 10;
		}
		
		int[] result = new int[count];
		
		int i = 0;
		t = N;
		while (t != 0) {
			result[i++] = (int) t%10;
			t /= 10;
		}
		
		return result;
	}
	private static long gcd(long x, long y) {
		if (x == 0)
			return y;
		else
			return gcd(y%x,x);
	}
	public static long GCD(long x, long y) {
		if (x == 0)
			return y;
		else
			if (x < y)
				return gcd(y%x,x);
			else 
				return gcd(x%y,y);
	}
	
	public static void getPrimeDivisors(long K, ArrayList<Long> unique_primes, ArrayList<Long> power) {		
		int i = 0;

		
		// Count the number of unique primes
		while (K != 1) {
			long sqrtK = (long) Math.sqrt(K);
			
			while (i < primes.length && K % primes[i] != 0 && primes[i] <= sqrtK) 
				++i;
			 
			if (primes[i] > sqrtK) {
				 unique_primes.add(K);
				 power.add(1l);
				 break;
			 }
			 
			 unique_primes.add((long) primes[i]);
			 int count = 0;
			 while (K % primes[i] == 0 && K != 1) {
				 K = K/primes[i];
				 ++count;
			 }
			 ++i;
			 power.add((long) count);
		}
	}

	public static void getPrimeDivisors(long K, HashMap<Long, Integer> info) {
		info.clear();
		int i = 0;
		
		// Count the number of unique primes
		while (K != 1) {
			long sqrtK = (long) Math.sqrt(K);
			
			while (i < primes.length && K % primes[i] != 0 && primes[i] <= sqrtK) 
				++i;
			 
			if (primes[i] > sqrtK) {
				info.put(K, 1);
				break;
			}
			 
			int count = 0;
			while (K % primes[i] == 0 && K != 1) {
				K = K/primes[i];
				++count;
			}
			info.put((long)primes[i], count);
			++i;
		}
	}

	private static void scan(ArrayList<Long> D, final long N, long product, int K, long level) {
		if (K == D.size())
			if (level % 2 == 0)
				total -= N/product;
			else
				total += N/product;
		else {
			scan(D, N, product, K+1, level);
			scan(D, N, product * D.get(K), K+1, level + 1);
		}
	}	

	static Long total = 0L;
	
	static long find(long K) {
		ArrayList<Long> D = new ArrayList<Long>();
		ArrayList<Long> P = new ArrayList<Long>();
		getPrimeDivisors(K, D, P);
		total = 0L;
		for (int i = 0; i < D.size(); i++)
			scan(D, K, D.get(i), i+1, 1);
		return total;
	}
	/**
	 * Return Euler Totient function
	 * @param N
	 * @return
	 */
	public static long Totient(long N) {
		ArrayList<Long> D = new ArrayList<Long>();
		ArrayList<Long> P = new ArrayList<Long>();
		getPrimeDivisors(N, D, P);
		double result = 1;
		
		for (int i = 0; i < D.size(); i++)
			result *= (D.get(i)-1)*Math.pow(D.get(i), P.get(i)-1);
		
		return (long) result;
	}
	
	public static long Totient_stupid(long N) {
		if (isPrime(N))
			return N-1;
		else 
			return N-find(N);		
	}
	
	public static long digitStat(long n) {
		short[] digit = new short[10];
		while (n > 0) {
			++digit[(int)n%10];
			n /= 10;
		}
		long H = 0;
		for (int i = 0; i <= 9; i++)
			H = H*10 + digit[i];
		return H;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt("21",5));
	}	
	/**
	 * Returns the square root of a real number
	 * @param N
	 * @param PRECISION
	 * @return
	 */
	public static String sqrt(String N, int PRECISION) {
		String integer = "", decimal = "";
		
		BigInteger r = BigInteger.ZERO;
		BigInteger p = BigInteger.ZERO;
		BigInteger x = null;		

		if (N.indexOf('.') != -1) {
			integer = N.substring(0, N.indexOf('.'));
			decimal = N.substring(N.indexOf('.') + 1, N.length()-1);
		}
		else  {
			integer = N;
		}
		
		if (integer.length() % 2 != 0)
			integer = '0' + integer;
		
		BigInteger t = BigInteger.ONE;
		
		do {
			r = new BigInteger(r.toString() + integer.charAt(0) + integer.charAt(1));
			integer = integer.substring(2, integer.length());

			final BigInteger _20 = new BigInteger("20");
			x = BigInteger.ZERO;
			
			while (p.multiply(_20).add(x).multiply(x).compareTo(r) <= 0)
				x = x.add(BigInteger.ONE);
			
			x = x.subtract(BigInteger.ONE);		
			r = r.subtract(p.multiply(_20).add(x).multiply(x));
			p = p.multiply(BigInteger.TEN).add(x);
			
			t = t.multiply(BigInteger.TEN);
		} while(integer.length() > 0);
		
		if (!decimal.equals("") || r.compareTo(BigInteger.ZERO) != 0) {
			while (decimal.length() < 2*PRECISION)
				decimal = decimal + '0';

			int precision = 0;
			
			while (r.compareTo(BigInteger.ZERO) == 0 || precision != PRECISION) {
				++precision;
				r = new BigInteger(r.toString() + decimal.charAt(0) + decimal.charAt(1));
				decimal = decimal.substring(2, decimal.length());
				
				final BigInteger _20 = new BigInteger("20");
				x = BigInteger.ZERO;
				
				while (p.multiply(_20).add(x).multiply(x).compareTo(r) <= 0)
					x = x.add(BigInteger.ONE);
				
				x = x.subtract(BigInteger.ONE);		
				r = r.subtract(p.multiply(_20).add(x).multiply(x));
				p = p.multiply(BigInteger.TEN).add(x);			
			}
		}
		
		return p.toString().substring(0, p.toString().length()-PRECISION) + (PRECISION>0?"."+p.toString().substring(p.toString().length()-PRECISION, p.toString().length()):"");	
	}

}
