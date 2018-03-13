package RSA;

import java.math.BigInteger;

import java.util.ArrayList;


public class DecimalToBinary {
	static BigInteger ZERO=BigInteger.valueOf(0);
	static BigInteger TWO=BigInteger.valueOf(2);
	public static ArrayList<Integer> convert(BigInteger e) {
		BigInteger r;
		ArrayList<Integer> array=new ArrayList<Integer>();
		while(e.compareTo(ZERO)>0){
			r=e.remainder(TWO);
			array.add(r.intValue());
			e=e.divide(TWO);
		}
		return array;
	}
}
