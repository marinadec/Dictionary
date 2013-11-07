package dict;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/
import java.util.*;

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

public class ModelLocaleImpl implements ModelLocale {
	
	//adding a Locale in a list
	public void add(LinkedList<Locale> list, int id, String abbr, String name) {
		list.add(new Locale(id, abbr, name));
	}
	
	//loading a list from a file
	public void load(LinkedList<Locale> list, String fileName) {
		String abbrev = null, locale_name = null;
		int locale_id = 0;
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
		 
			NodeList nList = doc.getElementsByTagName("locale");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					locale_id = new Integer(eElement.getAttribute("id"));
					abbrev = eElement.getElementsByTagName("abbrev").item(0).getTextContent();
					locale_name = eElement.getElementsByTagName("locale_name").item(0).getTextContent();
					list.add(new Locale(locale_id, abbrev, locale_name));					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//saving a list in a file, a file is made empty before the saving
	public void save(LinkedList<Locale> list, String fileName) {
		
		try {
			 
			int l_id = 0;
			String ab = null, name = null;
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("locales");
			doc.appendChild(rootElement);
	 
			for(int i = 0; i < list.size(); i++) {
				
				l_id = list.get(i).getLocale_id();
				ab = list.get(i).getAbbrev();
				name = list.get(i).getLocale_name();
				
				// Locale elements
				Element Locale = doc.createElement("locale");
				rootElement.appendChild(Locale);
		 
				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue(Integer.toString(l_id));
				Locale.setAttributeNode(attr);
		 
				// shorten way
				// staff.setAttribute("id", "1");
		 
				// abbrev elements
				Element abbrev = doc.createElement("abbrev");
				abbrev.appendChild(doc.createTextNode(ab));
				Locale.appendChild(abbrev);
				
				// locale_name elements
				Element locale_name = doc.createElement("locale_name");
				locale_name.appendChild(doc.createTextNode(name));
				Locale.appendChild(locale_name);
		 
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
	public void remove(LinkedList<Locale> list, int index) {
		list.remove(index);
	}
	
	//modifies an element with an index 'index' to an element new Locale(l_id, ab, name) //actually replaces
	public void modify(LinkedList<Locale> list, int index, int l_id, String ab, String name) {
		list.set(index, new Locale(l_id, ab, name));
	}
	
	//prints the list to the console
	public void printList(LinkedList<Locale> list) {
		for(Locale element : list)
			System.out.println(element);
	}
	
}

