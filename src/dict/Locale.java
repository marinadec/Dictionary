package dict;

public class Locale {
	private int locale_id;
	private String abbrev;
	private String locale_name;
		
	Locale(int id, String ab, String nm) {
		locale_id = id;
		abbrev = ab;
		locale_name = nm;
	}

	public int getLocale_id() {
		return locale_id;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public String getLocale_name() {
		return locale_name;
	}
	
	public String toString() {
		return Integer.toString(locale_id) + ' ' + abbrev + ' ' + locale_name;
	}
	
}


	

