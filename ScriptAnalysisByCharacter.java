import java.util.*;
import java.io.*;

public class ScriptAnalysisByCharacter {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("ultimateScript.txt"));
		String characterToAnalyze = "BOJACK"; // replace with character to analyze
		Map<String, Integer> characterWords = new HashMap<String, Integer>();
		int numberOfWords = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			while (line.length() == 0) {
				if (input.hasNextLine()) {
					line = input.nextLine(); // throw away that line and find the next line
				}
			}
			String character = "";
			String dialogue = "";

			character = line.substring(0, line.indexOf(":")); // CHARACTER: DIALOGUE		
			dialogue = line.substring(line.indexOf(":"), line.length()); // rest of the line
			while (input.hasNextLine()) {
				line = input.nextLine();
				if (line.length() == 0) {
					break;
				} else {
					dialogue += " " + line;
				}
			}
			if (characterToAnalyze.equals(character)) {
				String[] words = dialogue.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
				for (String word : words) {
					if (word.length() > 0) {
						numberOfWords++;
						if (characterWords.containsKey(word)) {
							characterWords.put(word, characterWords.get(word) + 1);
						} else {
							characterWords.put(word, 1);
						}
					}
				}
			}
		}
		PrintStream output = new PrintStream(new File("BoJackAnalysis.txt"));
		output.println("BoJack spoke " + numberOfWords + " words.");
		output.println();
		output.println(sortByValues(characterWords));
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
    	Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K key, K key2) {
				int compareKeys = map.get(key2).compareTo(map.get(key));
				if (compareKeys == 0) {
					return 1;
				} else {
					return compareKeys;
				}
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
    }
}