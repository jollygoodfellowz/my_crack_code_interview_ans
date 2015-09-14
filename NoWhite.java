import java.lang.System;

public class NoWhite {

	public NoWhite() {
	}

	public char[] removeWhite(char[] s, int length) {

		char [] strNoWhite = new char[length*3];
		for(int i = 0, j = 0; i < length; i++,j++) {
			if(s[i] == ' ') {
				strNoWhite[j++] = '%';
				strNoWhite[j++] = '2';
				strNoWhite[j] = '0';
			}
			else {
				strNoWhite[j] = s[i];
			}
		}
		return strNoWhite;
	}

	public static void main(String[] args) {
		String s = args[0];
		char [] str = s.toCharArray();

		NoWhite test = new NoWhite();
		str = test.removeWhite(str, s.length());

		for(char c: str)
			System.out.print(c);

		System.out.println();
	}
}