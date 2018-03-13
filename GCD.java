package RSA;

import java.math.BigInteger;
import java.util.Scanner;

public class GCD {
	private static final BigInteger ZERO = BigInteger.ZERO;
	public static BigInteger gcd(BigInteger m, BigInteger b) {
		// function to calculate the gcd of two numbers
		BigInteger r=new BigInteger("1");
		while (!r.equals(ZERO)) {
			r = m.remainder(b);
			m = b;
			b = r;
		}
		return m;
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	long a=s.nextLong();
	long b=s.nextLong();
	BigInteger a1=BigInteger.valueOf(a);
	BigInteger b1=BigInteger.valueOf(b);
	long res=gcd(a1, b1).longValue();
	System.out.println("the gcd of two numbers is "+res);
}

}
