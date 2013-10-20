package dict;
import java.util.*;

public interface Model {
	
	//adding a word in a list
	void add(LinkedList<word> list, int id, String wrd, String pos, String lang);
	
	//loading a list from a file
	void save(LinkedList<word> list, String fileName);
	
	//saving a list in a file, a file is made empty before the saving
	void load(LinkedList<word> list, String fileName);
	
	//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
	void remove(LinkedList<word> list, int index);
	
	//modifies an element with an index 'index' to an element new word(id, wrd, pos, lang) //actually replaces
	void modify(LinkedList<word> list, int index, int id, String wrd, String pos, String lang);
	
	//prints the list to the console
	void printList(LinkedList<word> list);
	
}
