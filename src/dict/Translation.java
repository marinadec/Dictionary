package dict;

public class Translation {
		private int transl_id;		//id of the translation in this class
		private int main_id;		//id of the main (english) word
		private  int word_id;		//id of the word from the class 'word'
		private int lang_id;		//id of the language of the translation
		private String transl;		//translation itself
		
		Translation(int transl_id, int main_id, int word_id, int lang_id, String transl) {
			this.transl_id = transl_id;
			this.main_id = main_id;
			this.word_id = word_id;
			this.lang_id = lang_id;
			this.transl = transl;
		}

		public int getTransl_id() {
			return transl_id;
		}

		public int getMain_id() {
			return main_id;
		}

		public int getWord_id() {
			return word_id;
		}

		public int getLang_id() {
			return lang_id;
		}

		public String getTransl() {
			return transl;
		}
		
		public String toString() {
			return Integer.toString(transl_id) + ' ' + 
					Integer.toString(main_id) + ' ' + 
					Integer.toString(word_id) + ' ' +
					Integer.toString(lang_id) + ' ' +
					transl;
		}
}
