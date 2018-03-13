package RSA;
import java.io.FileInputStream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class StartRsa {
	static BigInteger bottom = BigInteger.valueOf(2);
	static BigInteger top = BigInteger.valueOf(2).pow(512);
	static BigInteger THREE = BigInteger.valueOf(3);
	static BigInteger ONE = BigInteger.valueOf(1);

	public static void main(String[] args) {
		// generate p which is a prime number
		BigInteger p=Generate.generatenumber(bottom, top);
		// generate q which is a prime number
		BigInteger q=Generate.generatenumber(bottom, top);
		// calculate n=p*q
		BigInteger n = p.multiply(q);
		// calculate phi=(p-1)*(q-1)
		BigInteger phi = p.subtract(ONE);
		phi = phi.multiply(q.subtract(ONE));
		// calculate public key e which is between 3 and n-1 and relatively
		// co-prime to p-1 and q-1
		BigInteger e=Generate.generatenumber(THREE, n.subtract(ONE));
		// calculate private key d using e,n
		BigInteger d= ModularInverse.MulInv(e,phi);
		// display p,q,e,d,n
		System.out.println("p=" + p);
		System.out.println("q=" + q);
		System.out.println("n=" + n);
		System.out.println("phi=" + phi);
		System.out.println("e=" + e);
		System.out.println("d=" + d);
		// read each byte from input file and store it in an arraylist
		System.out.println("Raw message");
		ArrayList<Integer> raw = new ArrayList<Integer>();
		try {
			FileInputStream fin = new FileInputStream("D:\\raw.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				raw.add(i);
				System.out.print((char) i);
			}
			fin.close();
		} catch (Exception f) {
			System.out.println(f);
		}
		System.out.println();
		//display the raw message
	    for(int i=0; i<raw.size(); i++){
	    	System.out.print(raw.get(i)+" ");
	    }
		// encrypt the raw message
		ArrayList<BigInteger> encryptarray = new ArrayList<BigInteger>();
		//encryptarray = Encryption.encrypt(raw, BigInteger.valueOf(17), BigInteger.valueOf(86609));
		encryptarray = Encryption.encrypt(raw, e, n);
		// display encrypted message
		System.out.println();
		System.out.println("ENCRYPTED MESSAGE");
		Iterator<BigInteger> itr = encryptarray.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "			 ");
		}
		// decrypt the encrypted message
		ArrayList<BigInteger> decryptarray = new ArrayList<BigInteger>();
		//decryptarray = Decryption.decrypt(encryptarray, BigInteger.valueOf(65777), BigInteger.valueOf(86609));
		decryptarray = Decryption.decrypt(encryptarray, d, n);
		//display the decrypted message
		System.out.println();
		System.out.println("DECRYPTED MESSAGE");
		Iterator<BigInteger> itr2=decryptarray.iterator();
		while(itr2.hasNext()){
			System.out.print(itr2.next()+" ");
		}
	}
}
