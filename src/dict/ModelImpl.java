package dict;
/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/
import java.util.*;
//import java.lang.Enum; 
//import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ModelImpl implements Model {
	
	//adding a word in a list
	public void add(LinkedList<word> list, int id, String wrd, PartOfSpeech pos, int lang) {
		list.add(new word(id, wrd, pos, lang));
	}
	
	//loading a list from a file
	public void load(LinkedList<word> list, String fileName) {
		String word = null;
		PartOfSpeech part_of_speech = null;
		int word_id = 0, language_id = 0;
		//here was previous variant with read info from a file

		try {
			 
			File fXmlFile = new File(fileName);		//like "D:\\Java_projects\\test\\word.xml"
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//doc.getDocumentElement().normalize();
		 
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("word");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					word_id = new Integer(eElement.getAttribute("id"));
					word = eElement.getElementsByTagName("word_name").item(0).getTextContent();
					part_of_speech = PartOfSpeech.valueOf(eElement.getElementsByTagName("part_of_speech").item(0).getTextContent());
					language_id = new Integer(eElement.getElementsByTagName("language_id").item(0).getTextContent());
					list.add(new word(word_id, word, part_of_speech, language_id));					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//saving a list in a file, a file is made empty before the saving
	public void save(LinkedList<word> list, String fileName) {
		
		try {
			 
			int id = 0, lang = 0;
			String wrd = null;
			PartOfSpeech pos = null;
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("words");
			doc.appendChild(rootElement);
	 
			for(int i = 0; i < list.size(); i++) {
				
				id = list.get(i).getWord_id();
				wrd = list.get(i).getWord();
				pos = list.get(i).getPart_of_speech();
				lang = list.get(i).getLanguage_id();
				
				// word elements
				Element word = doc.createElement("word");
				rootElement.appendChild(word);
		 
				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue(Integer.toString(id));
				word.setAttributeNode(attr);
		 
				// shorten way
				// staff.setAttribute("id", "1");
		 
				// word_name elements
				Element word_name = doc.createElement("word_name");
				word_name.appendChild(doc.createTextNode(wrd));
				word.appendChild(word_name);
		 
				// part_of_speech elements
				Element part_of_speech = doc.createElement("part_of_speech");
				part_of_speech.appendChild(doc.createTextNode(pos.toString()));
				word.appendChild(part_of_speech);
		 
				// language_id elements
				Element language_id = doc.createElement("language_id");
				language_id.appendChild(doc.createTextNode(Integer.toString(lang)));
				word.appendChild(language_id);
		  
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(fileName));  //like "D:\\Java_projects\\Dictionary\\outputXML.xml"
		 
				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
			 
				//System.out.println("File saved!");
			} 
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			} catch (TransformerException tfe) {
				tfe.printStackTrace();
				}
}
	
	//removes an element from the list with an index 'index' (index = 0, 1, 2,...)
	public void remove(LinkedList<word> list, int index) {
		list.remove(index);
	}
	
	//modifies an element with an index 'index' to an element new word(id, wrd, pos, lang) //actually replaces
	public void modify(LinkedList<word> list, int index, int id, String wrd, PartOfSpeech pos, int lang) {
		list.set(index, new word(id, wrd, pos, lang));
	}
	
	//prints the list to the console
	public void printList(LinkedList<word> list) {
		for(word element : list)
			System.out.println(element);
	}
	
}
