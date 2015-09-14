import java.util.HashMap;
import java.lang.System;
import java.lang.Integer;
import java.lang.String;

/**Solution to 1.3 of cracking the code interview*/
public class StringPerm {

	public StringPerm() {
	}	

	public HashMap<Character,Integer> getMap(String s) {
		HashMap<Character,Integer> smap = new HashMap<Character,Integer>();

		char[] sArr = s.toCharArray();
		for(char c: sArr) {
			if(smap.containsKey(c)) {
				int add = smap.get(c) + 1;
				smap.put(c, add);
			}
			else {
				smap.put(c,1);
			}
		}
		return smap;
	}

	public boolean isPerm(String s, String o) {

		if(s.length() != o.length()) return false;

		HashMap<Character,Integer> smap = getMap(s);
		HashMap<Character,Integer> omap = getMap(o);

		char[] sArr = s.toCharArray();
		for(char c: sArr)
			if(smap.get(c) != omap.get(c))
				return false;
		return true;
	}

	public static void main(String[] args) {
		String s = args[0];
		String o = args[1];

		StringPerm test = new StringPerm();
		System.out.println(test.isPerm(s,o));
	}
}