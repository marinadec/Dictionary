package dict;
import java.util.*;
//import java.lang.Enum; 

public interface Model {
	
	//adding a word in a list
	void add(LinkedList<word> list, int id, String wrd, PartOfSpeech pos, int lang);
	
	//saving a list in a file, a file is made empty before the saving
	void save(LinkedList<word> list, String fileName);
	
	//loading a list from a file
	void load(LinkedList<word> list, String fileName);
	
	//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
	void remove(LinkedList<word> list, int index);
	
	//modifies an element with an index 'index' to an element new word(id, wrd, pos, lang) //actually replaces
	void modify(LinkedList<word> list, int index, int id, String wrd, PartOfSpeech pos, int lang);
	
	//prints the list to the console
	void printList(LinkedList<word> list);
	
}
