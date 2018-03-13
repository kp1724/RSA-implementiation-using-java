package RSA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class MillerRabin {
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number");
		int k = 10;
		BigInteger p1 = s.nextBigInteger();
		boolean result = true;
		if (!checkPrime(p1, k)) {
			result = false;
		}
		if (result) {
			System.out.println("the number is prime");
		} else
			System.out.println("the number is not prime");
	}

	public static boolean checkPrime(BigInteger p1, int k) {
		// TODO Function for Primality test using miller Rabin method
		if (p1.compareTo(THREE) < 0) {
			return true;
		}
		for (int i = 0; i < k; i++) {
			BigInteger a = Generate.uniformRandom(TWO, p1.subtract(ONE));
			if (composite(a, p1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean composite(BigInteger a, BigInteger p1) {
		// TODO function to check if number is composite
		BigInteger s = p1.subtract(ONE);
		ArrayList<BigInteger> array = new ArrayList<BigInteger>();
		while (s.compareTo(ZERO) > 0) {
			BigInteger r = s.remainder(TWO);
			array.add(r);
			s = s.divide(TWO);
		}
		BigInteger d = new BigInteger("1");
		for (int i = array.size() - 1; i >= 0; i--) {
			BigInteger x = d;
			d = d.multiply(d);
			d = d.remainder(p1);
			if (d.equals(ZERO) && !x.equals(ONE) && !x.equals(p1.subtract(ONE))) {
				return true;
			}
			if (array.get(i).equals(ONE)) {
				d = d.multiply(a);
				d = d.remainder(p1);
			}
		}
		if (!d.equals(ONE)) {
			return true;
		}
		return false;
	}	
}
