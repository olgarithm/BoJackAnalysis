import java.util.*;
import java.io.*;

public class ScriptAnalysis {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("bojackpilot.txt"));
		List<String> characters = Arrays.asList("BOJACK", "DIANE", "MR. PEANUTBUTTER", "CAROLYN", "TODD");
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
			if (characters.contains(character)) {
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
		}
		PrintStream output = new PrintStream(new File("pilotEpisodeMappedTry2.txt"));
		output.println(sortByValues(characterWords));
        /*for (Map.Entry<String, <String, Integer>> character : characterWords.entrySet()) {
            output.println("\"" + character.getKey() + "\" : \"" + character.getValue() + "\",");
        }*/
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