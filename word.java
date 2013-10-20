package dict;

public class word {
	private int word_id;
	private String word;
	private String part_of_speech;
	private String language_id;
	
	word(int id, String w, String p, String l) {
		word_id = id;
		word = w;
		part_of_speech = p;
		language_id = l;
	}
				
	public String getWord() {
		return this.word;
	}

	public int getWord_id() {
		return word_id;
	}

	public String getPart_of_speech() {
		return part_of_speech;
	}

	public String getLanguage_id() {
		return language_id;
	}

	public String toString() {
		return Integer.toString(word_id) + ' ' + word + ' ' + part_of_speech + ' ' + language_id;
	}
}
