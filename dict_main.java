package dict;
import java.util.*;

public class dict_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModelImpl model = new ModelImpl();
		LinkedList<word> m1 = new LinkedList<word>();
			
		model.load(m1, "input.txt");
		
		//print all words	
		/*model.printList(m1);		
		System.out.println("\n");*/
		
		m1.add(new word(4, "bird", "noun", "en"));
		
		/*model.printList(m1);*/
		
		model.add(m1, 5, "big", "adjective", "en");
		
		/*for(word element : m1)
			System.out.println(element);*/
				
		/*for(int i = 0; i < m1.size(); i++) {
			System.out.println(m1.get(i).getWord());
		}*/
		
		model.save(m1, "output.txt");		
		
		model.remove(m1, 1);
		
		/*model.printList(m1);
		System.out.println('\n');*/
		
		model.modify(m1, 2, 10, "волчок", "noun", "ru");
		
		/*model.printList(m1);*/
	
		model.save(m1, "output.txt");
		
		model.printList(m1);
	}

}
