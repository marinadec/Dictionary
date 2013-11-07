package dict;
import java.util.*;

public interface ModelTrans {
		
		//adding a translation in a list
		void add(LinkedList<Translation> list, int transl_id, int main_id, int word_id, int lang_id, String transl);
		
		//saving a list in a file, a file is made empty before the saving
		void save(LinkedList<Translation> list, String fileName);
		
		//loading a list from a file
		void load(LinkedList<Translation> list, String fileName);
		
		//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
		void remove(LinkedList<Translation> list, int index);
		
		//modifies an element with an index 'index' to an element new Translation(transl_id, main_id, word_id, lang_id, transl) //actually replaces
		void modify(LinkedList<Translation> list, int index, int transl_id, int main_id, int word_id, int lang_id, String transl);
		
		//prints the list to the console
		void printList(LinkedList<Translation> list);

}
