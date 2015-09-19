import java.lang.System;

public class Split {

	public Split() {
	}

	public static void main(String[] args) {

		String s1 = args[0];
		String s2 = args[1];

		String[] ans1 = s1.split(",");
		String[] ans2 = s2.split("\\d");

		System.out.println("Arg 1 split");
		for(String str: ans1)
			System.out.println(str);

		System.out.println();
		System.out.println("Arg 2 split");
		for(String str: ans2)
			System.out.println(str);
	}
}
