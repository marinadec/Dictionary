package dict;
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
	
public class ModelTransImpl implements ModelTrans {
	
	public void add(LinkedList<Translation> list, int transl_id, int main_id, int word_id, int lang_id, String transl) {
		list.add(new Translation(transl_id, main_id, word_id, lang_id, transl));
	}
	
	//loading a list from a file
	public void load(LinkedList<Translation> list, String fileName) {
		int transl_id = 0, main_id = 0, word_id = 0, lang_id = 0;
		String transl = null;
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
		 
			NodeList nList = doc.getElementsByTagName("Translation");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					transl_id = new Integer(eElement.getAttribute("id"));
					main_id = new Integer(eElement.getElementsByTagName("main_id").item(0).getTextContent());
					word_id = new Integer(eElement.getElementsByTagName("word_id").item(0).getTextContent());
					lang_id = new Integer(eElement.getElementsByTagName("lang_id").item(0).getTextContent());
					transl = eElement.getElementsByTagName("transl").item(0).getTextContent();
					list.add(new Translation(transl_id, main_id, word_id, lang_id, transl));					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//saving a list in a file, a file is made empty before the saving
	public void save(LinkedList<Translation> list, String fileName) {
		
		try {
			 			
			int t_id = 0, m_id = 0, w_id = 0, l_id = 0;
			String transl = null;
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("translations");
			doc.appendChild(rootElement);
	 
			for(int i = 0; i < list.size(); i++) {
				
				t_id = list.get(i).getTransl_id();
				m_id = list.get(i).getMain_id();
				w_id = list.get(i).getWord_id();
				l_id = list.get(i).getLang_id();
				transl = list.get(i).getTransl();
				
				// Translation elements
				Element Translation = doc.createElement("Translation");
				rootElement.appendChild(Translation);
		 
				// set attribute to staff element
				Attr attr = doc.createAttribute("id");
				attr.setValue(Integer.toString(t_id));
				Translation.setAttributeNode(attr);
		 
				// shorten way
				// staff.setAttribute("id", "1");
		 
				// main_id elements
				Element main_id = doc.createElement("main_id");
				main_id.appendChild(doc.createTextNode(Integer.toString(m_id)));
				Translation.appendChild(main_id);
		 
				// word_id elements
				Element word_id = doc.createElement("word_id");
				word_id.appendChild(doc.createTextNode(Integer.toString(w_id)));
				Translation.appendChild(word_id);
		 
				// language_id elements
				Element lang_id = doc.createElement("lang_id");
				lang_id.appendChild(doc.createTextNode(Integer.toString(l_id)));
				Translation.appendChild(lang_id);
				
				// transl elements
				Element tr = doc.createElement("transl");
				tr.appendChild(doc.createTextNode(transl));
				Translation.appendChild(tr);
		  
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
	public void remove(LinkedList<Translation> list, int index) {
		list.remove(index);
	}
	
	//modifies an element with an index 'index' to an element new word(id, wrd, pos, lang) //actually replaces
	public void modify(LinkedList<Translation> list, int index, int transl_id, int main_id, int word_id, int lang_id, String transl) {
		list.set(index, new Translation(transl_id, main_id, word_id, lang_id, transl));
	}
	
	//prints the list to the console
	public void printList(LinkedList<Translation> list) {
		for(Translation element : list)
			System.out.println(element);
	}
}
