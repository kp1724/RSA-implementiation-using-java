package RSA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Decryption {
	public static ArrayList<BigInteger> decrypt(
			ArrayList<BigInteger> encryptarray, BigInteger d, BigInteger n) {
		Iterator<BigInteger> itr = encryptarray.iterator();
		ArrayList<Integer> darr = new ArrayList<Integer>();
		darr = DecimalToBinary.convert(d);
		int k = darr.size();
		ArrayList<BigInteger> resarr = new ArrayList<BigInteger>();
		while (itr.hasNext()) {
			BigInteger m = itr.next();
			BigInteger c = BigInteger.valueOf(1);
			int j = k;
			while (--j >= 0) {
				c = c.multiply(c);
				c = c.remainder(n);
				if (darr.get(j) == 1) {
					c = c.multiply(m);
					c = c.remainder(n);
				}
			}
			resarr.add(c);
		}
		return resarr;
	}
}
