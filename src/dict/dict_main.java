package dict;
import java.util.*;

public class dict_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModelImpl model = new ModelImpl();
		LinkedList<word> m1 = new LinkedList<word>();
			
		//model.load(m1, "input.txt");
		model.load(m1, "D:\\Java_projects\\Dictionary\\inputXML.xml");
		//model.printList(m1);
		
		//print all words	
		/*model.printList(m1);		
		System.out.println("\n");*/
		
		//m1.add(new word(4, "bird", "noun", 2)); //2 - en, 1 - ru
		model.add(m1, 4, "bird", PartOfSpeech.NOUN, 2);		
		
		/*model.printList(m1);*/
		
		model.add(m1, 5, "big", PartOfSpeech.ADJECTIVE, 2);
		
		/*for(word element : m1)
			System.out.println(element);*/
				
		/*for(int i = 0; i < m1.size(); i++) {
			System.out.println(m1.get(i).getWord());
		}*/
		
		model.save(m1, "D:\\Java_projects\\Dictionary\\outputXML.xml");		
		
		model.remove(m1, 1);
		
		/*model.printList(m1);
		System.out.println('\n');*/
		
		model.modify(m1, 2, 10, "wolf", PartOfSpeech.NOUN, 2);
		
		/*model.printList(m1);*/
	
		model.save(m1, "D:\\Java_projects\\Dictionary\\outputXML.xml");
		
		model.printList(m1);
		
		System.out.println();
		
//Translation
	
		ModelTransImpl md = new ModelTransImpl();
		LinkedList<Translation> ls = new LinkedList<Translation>();
			
		md.load(ls, "D:\\Java_projects\\Dictionary\\inputTransXML.xml");
				
		md.printList(ls);
		
		md.remove(ls, 1);
		
		md.save(ls, "D:\\Java_projects\\Dictionary\\outputTransXML.xml");
			
		System.out.println();
		
//Locale
		
		ModelLocaleImpl loc = new ModelLocaleImpl();
		LinkedList<Locale> lst = new LinkedList<Locale>();
		
		loc.load(lst, "D:\\Java_projects\\Dictionary\\inputLocaleXML.xml");
		
		loc.printList(lst);
		
		loc.remove(lst, 1);
		
		loc.save(lst, "D:\\Java_projects\\Dictionary\\outputLocaleXML.xml");
	}
}
