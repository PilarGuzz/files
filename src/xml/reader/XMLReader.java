package xml.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xml.model.Coche;

public class XMLReader {
	
	public List<Coche> cargarArchivoDatos(String path){
		List<Coche> coches = new ArrayList<>();
		
		File archivo = new File(path);
		
		if(archivo.exists()) {
			try {
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document documento = builder.parse(archivo);
				
				//Document doc = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().parse(archivo);
				
				documento.getDocumentElement().normalize();
				//Primero obtengo todos los nodos de etiqueta "coche"
				NodeList listaNodos = documento.getElementsByTagName("coche");
				
				//Para cada nodo lo transformo en elemento para acceder a sus nodos hijos
				for (int i = 0; i < listaNodos.getLength(); i++) {
					//Transformo mi nodo a Element
					Element elemento = (Element)listaNodos.item(i);
					System.out.println(elemento.getAttribute("id"));
					System.out.println(elemento.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println(elemento.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println(elemento.getElementsByTagName("cilindrada").item(0).getTextContent());

					int id = Integer.valueOf(elemento.getAttribute("id"));
					String marca = elemento.getElementsByTagName("marca").item(0).getTextContent();
					String modelo = elemento.getElementsByTagName("modelo").item(0).getTextContent();
					String cilindrada = elemento.getElementsByTagName("cilindrada").item(0).getTextContent();

					Coche coche = new Coche(id, modelo, marca, cilindrada);
					coches.add(coche);
					
				}
				
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return coches;
	}

}
