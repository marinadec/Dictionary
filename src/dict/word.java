package dict;

//import java.lang.Enum; 

enum PartOfSpeech {
	NOUN, ADJECTIVE, VERB, CONJUNCTION, PREPOSITION, NUMERAL, ADVERB, PRONOUN 
}

public class word {
	private int word_id;
	private String word;
	private PartOfSpeech part_of_speech;
	private int language_id;
	
	word(int id, String w, PartOfSpeech p, int l) {
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

	public PartOfSpeech getPart_of_speech() {
		return part_of_speech;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public String toString() {
		return Integer.toString(word_id) + ' ' + word + ' ' + part_of_speech + ' ' + Integer.toString(language_id);
	}
}
