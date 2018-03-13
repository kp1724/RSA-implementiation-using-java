package RSA;

import java.util.ArrayList;
import java.util.Scanner;

public class ModularExpo {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		System.out.println("enter the base number");
		long a=s.nextLong();
		System.out.println("enter the power");
		long d=s.nextLong();
		System.out.println("enter the number");
		long n=s.nextLong();
		long res=ModExpo(a,d,n);
		System.out.println("the result is "+res);
	}

	public static long ModExpo(long a, long d, long n) {
		// TODO function to calculate a^d mod n using modular exponentiation
		ArrayList<Long>array =new ArrayList<Long>();
		long b=d;
		while(b>0){
			long r=b%2;
			array.add(r);
			b=b/2;
		}
		long res=1;
		for(int i=array.size()-1; i>=0;i--){
			res=(res*res)%n;
			if(array.get(i)==1){
				res=(res*a)%n;
			}
		}
		return res;
	}

}
