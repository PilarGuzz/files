package xml;

import xml.reader.XMLReader;

public class Main {

	public static void main(String[] args) {
		
		XMLReader reader = new XMLReader();
		reader.cargarArchivoDatos("./archivos/coches.xml");
	}
}
