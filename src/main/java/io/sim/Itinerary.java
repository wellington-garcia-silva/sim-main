package io.sim;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Itinerary {

	private boolean on;//W: retorna estado para verificar se está ok
	private String uriItineraryXML;
	private String[] itinerary;
	private String idItinerary;

	/////////////
	private String ponto;

	public Itinerary(String _uriRoutesXML, String _idRoute) {//W: pega o arquivo (rota, id da rota)
		this.uriItineraryXML = _uriRoutesXML;
		this.idItinerary = _idRoute;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(this.uriItineraryXML);

			NodeList nList = doc.getElementsByTagName("vehicle");
			
			for (int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String idRouteAux = this.idItinerary;
					Node node = elem.getElementsByTagName("route").item(i);//antes era 0 no lugar de i
					Element edges = (Element) node;

					// Extract the specified edge based on the edge index
					this.itinerary = new String[] { idRouteAux, edges.getAttribute("edges") };

					

				}
			}
            
			Thread.sleep(100);//W: aguarda
			this.on = true; //W: retorna verdadeiro so se 

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getIDItinerary() {
		return this.idItinerary;
	}

	public String getUriItineraryXML() {
		return this.uriItineraryXML;
	}

	public String[] getItinerary() {
		return this.itinerary;
	}

	public String getIdItinerary() {
		return this.idItinerary;
	}

	public boolean isOn() {
		return this.on;
	}
}