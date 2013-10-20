package dict;
/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/
import java.util.*;
import java.io.*;

public class ModelImpl implements Model {
	
	//adding a word in a list
	public void add(LinkedList<word> list, int id, String wrd, String pos, String lang) {
		list.add(new word(id, wrd, pos, lang));
		/*for(word element : mm)
			System.out.println(element);*/
	}
	
	//loading a list from a file
	public void load(LinkedList<word> list, String fileName) {
		String temp = null;
		String word = null, part_of_speech = null, language_id = null;
		int word_id = 0;
		int i = 0, j = 0;
		//reading the file into one string
		//making one string into words, then to LinkedList
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			while((temp = br.readLine()) != null) {
				i = 0;
				j = i;
				while(temp.charAt(j) != ' ')
					j++;
				word_id = new Integer(temp.substring(i, j));
				j += 1;
				i = j;
				while(temp.charAt(j) != ' ')
					j++;
				word = temp.substring(i, j);
				j += 1;
				i = j;
				while(temp.charAt(j) != ' ')
					j++;
				part_of_speech = temp.substring(i, j);
				j += 1;
				i = j;
				language_id = temp.substring(i, temp.length());
				list.add(new word(word_id, word, part_of_speech, language_id));
			}
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}
	
	//saving a list in a file, a file is made empty before the saving
	public void save(LinkedList<word> list, String fileName) {
		int id = 0;
		String wrd = null, pos = null, lang = null;
		try (FileWriter fw = new FileWriter(fileName))
		{
			for(int i = 0; i < list.size(); i++) {
				id = list.get(i).getWord_id();
				wrd = list.get(i).getWord();
				pos = list.get(i).getPart_of_speech();
				lang = list.get(i).getLanguage_id();
				fw.write(Integer.toString(id) + ' ' + wrd + ' ' + pos + ' ' + lang + '\n');
			}							
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}	
	}
	
	//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
	public void remove(LinkedList<word> list, int index) {
		list.remove(index);
	}
	
	//modifies an element with an index 'index' to an element new word(id, wrd, pos, lang) //actually replaces
	public void modify(LinkedList<word> list, int index, int id, String wrd, String pos, String lang) {
		list.set(index, new word(id, wrd, pos, lang));
	}
	
	//prints the list to the console
	public void printList(LinkedList<word> list) {
		for(word element : list)
			System.out.println(element);
	}
	
}
