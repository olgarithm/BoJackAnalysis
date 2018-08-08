import java.util.*;
import java.io.*;

public class MakeTopWordArray {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("MostCommonWords.txt"));
		List<String> words = new ArrayList<String>();
		while (input.hasNextLine()) {
			words.add("\"" + input.nextLine() + "\"");
		}
		String[] wordArray = words.toArray(new String[words.size()]);
		PrintStream output = new PrintStream(new File("MostCommonWordsArray.txt"));
		output.println(Arrays.toString(wordArray));
	}
}