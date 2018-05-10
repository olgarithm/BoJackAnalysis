import java.util.*;
import java.io.*;

public class ScriptAnalysis {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("bojackpilot.txt"));
		Map<String, Map<String, Integer>> characterWords = new HashMap<String, Map<String, Integer>>();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			while (line.length() == 0) {
				if (input.hasNextLine()) {
					line = input.nextLine(); // throw away that line and find the next line
				} else {
					throw new IllegalArgumentException("out of stuff");
				}
			}
			String character = "";
			String dialogue = "";

			character = line.substring(0, line.indexOf(":")); // CHARACTER: DIALOGUE
			dialogue = line.substring(line.indexOf(":")); // rest of the line
			while (input.hasNextLine()) {
				line = input.nextLine();
				if (line.length() == 0) {
					break;
				} else {
					dialogue += " " + line;
				}
			}
			String[] words = dialogue.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
			if (!characterWords.containsKey(character)) {
				characterWords.put(character, new TreeMap<String, Integer>());
			}

			for (String word : words) {
				if (word.length() > 0) {
					Map<String, Integer> thisCharWords = characterWords.get(character);
					if (thisCharWords.get(word) == null) {
						thisCharWords.put(word, 1);
					} else {
						thisCharWords.put(word, thisCharWords.get(word) + 1);
					}
				}
			}
		}
		System.out.println(characterWords);
	}
}