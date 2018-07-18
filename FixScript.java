// Assuming the input text looks like:
//
// 		3
// 		00:00:14,520 --> 00:00:17,188
// 		Oh, is it this guy?
// 		Never travel without it.
//
// strips the number and the timestamp of the script 
// and gets rid of an <b> or <i> tags

import java.io.*;
import java.util.*;

public class FixScript {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("s1_e7.txt"));
		PrintStream output = new PrintStream(new File("s1_e7_edit.txt"));
		while (input.hasNextLine()) {
			String line = getRidOfTags(input.nextLine());
			if (isNumeric(line)) {
				input.nextLine(); // throw away next line
			} else {
				output.println(line);
				String nextLine = getRidOfTags(input.nextLine());
				while (!nextLine.equals("") && !isNumeric(nextLine) && !nextLine.startsWith("00")) {
					nextLine.replace("<i>", "");
					output.println(nextLine);
					nextLine = getRidOfTags(input.nextLine());
				}
				output.println();
			}
		}
	}

	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}

	public static String getRidOfTags(String str) {
		str = str.replace("<i>", "");
		str = str.replace("</i>", "");
		str = str.replace("<b>", "");
		str = str.replace("</b>", "");
		return str;
	}
}