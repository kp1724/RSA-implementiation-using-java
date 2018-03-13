package RSA;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Encryption {
	public static ArrayList<BigInteger> encrypt(ArrayList<Integer> array,
			BigInteger e, BigInteger n) {
		Iterator<Integer> itr = array.iterator();
		ArrayList<Integer> darr = new ArrayList<Integer>();
		darr = DecimalToBinary.convert(e);
		int k = darr.size();
		ArrayList<BigInteger> resarr = new ArrayList<BigInteger>();
		while (itr.hasNext()) {
			int m = itr.next();
			BigInteger c = BigInteger.valueOf(1);
			int j = k;
			while (--j >= 0) {
				c = c.multiply(c);
				c = c.remainder(n);
				if (darr.get(j) == 1) {
					c = c.multiply(BigInteger.valueOf(m));
					c = c.remainder(n);
				}
			}
			resarr.add(c);
		}
		return resarr;
	}
}
