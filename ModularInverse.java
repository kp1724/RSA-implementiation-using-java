package RSA;
import java.math.BigInteger;
import java.util.Scanner;
public class ModularInverse {
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long m, b;
		System.out.println("enter the exponent numbers");
		m = s.nextLong();
		System.out.println("enter the modulus");
		b = s.nextLong();
		BigInteger m1=BigInteger.valueOf(m);
		BigInteger b1=BigInteger.valueOf(b);
		BigInteger res = MulInv(m1, b1);
		System.out.println("the multiplicative inverse of two numbers is "
				+ res);
	}
	public static BigInteger MulInv(BigInteger b, BigInteger m) {
		// function to calculate the multiplicative inverse of two numbers
		BigInteger a1=new BigInteger("1");
		BigInteger a2=new BigInteger("0");
		BigInteger a3=m;
		BigInteger b1=new BigInteger("0");
		BigInteger b2=new BigInteger("1");
		BigInteger b3=b;
		while (true) {
			if (b3.equals(ZERO)) {
				a3 = GCD.gcd(b,m);
				return a3;
			}
			if (b3.equals(ONE)) {
				b3 = GCD.gcd(b,m);
				if (b2.compareTo(ZERO)<0) {
					b2 = b2.add(m);
				}
				return b2;
			}
			BigInteger q = a3.divide(b3);
			BigInteger t1, t2, t3;
			t1 = a1.subtract(q.multiply(b1));
			t2 = a2.subtract(q.multiply(b2));
			t3 = a3.subtract(q.multiply(b3));
			a1 = b1;
			a2 = b2;
			a3 = b3;
			b1 = t1;
			b2 = t2;
			b3 = t3;
		}
	}
}

