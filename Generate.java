package RSA;

import java.math.BigInteger;
import java.util.Random;

public class Generate {
	public static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
		Random rnd = new Random();
		BigInteger res;
		do {
			res = new BigInteger(top.bitLength(), rnd);
		} while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
		return res;
	}
	public static BigInteger generatenumber(BigInteger bottom, BigInteger top) {
		BigInteger p;
		while (true) {
			p = Generate.uniformRandom(bottom, top);
			if (MillerRabin.checkPrime(p, 10)) {
				break;
			}
		}
		return p;
	}
}
