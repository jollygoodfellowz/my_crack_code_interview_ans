import java.lang.System;
import java.lang.Long;

public class RecFib {

	public RecFib() {
	}

	public static long recFib(long n) {
		if(n == 2)
			return 1;
		else if(n < 2)
			return 0;

		return recFib(n-1) + recFib(n-2);
	}

	public static long dpFib(long n) {
		Long num = new Long(n);
		int length = num.intValue();
		int[] lookup = new int[length];

		lookup[0] = 0;
		lookup[1] = 1;

		for(int i = 2; i < length; i++)
			lookup[i] = lookup[i-1] + lookup[i-2];

		return lookup[length-1];
	}
	public static void main(String[] args) {
		String s = args[0];
		long fibnum = Long.parseLong(args[0]);
		System.out.println(recFib(fibnum));
		System.out.println(dpFib(fibnum));

	}
}