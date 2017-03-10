package test;

import java.lang.Character.UnicodeBlock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String s = "aasÍõ/";
		for(char c : s.toCharArray()){
			UnicodeBlock ub = UnicodeBlock.of(c);
			if(ub == UnicodeBlock.BASIC_LATIN){
				sb.append(c);
			}else if(c > 255){
				sb.append("\\u" + Integer.toHexString((int) c));
			}else{
				sb.append("\\" + Integer.toHexString((int) c));
			}
		}
		String unicodeStr = sb.toString();
		System.out.println(unicodeStr);
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(unicodeStr);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
			unicodeStr = unicodeStr.replace(matcher.group(1), ch + "");
		}
		System.out.println(unicodeStr);
	}

}
