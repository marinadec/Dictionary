package dict;
//import java.lang.Enum; 
import java.util.*;

public interface ModelLocale {
	
	//adding a locale in a list
	void add(LinkedList<Locale> list, int id, String abbr, String name);
	
	//saving a list in a file, a file is made empty before the saving
	void save(LinkedList<Locale> list, String fileName);
	
	//loading a list from a file
	void load(LinkedList<Locale> list, String fileName);
	
	//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
	void remove(LinkedList<Locale> list, int index);
	
	//modifies an element with an index 'index' to an element new Locale(id, abbr, name) //actually replaces
	void modify(LinkedList<Locale> list, int index, int id, String abbr, String name);
	
	//prints the list to the console
	void printList(LinkedList<Locale> list);
	
}
