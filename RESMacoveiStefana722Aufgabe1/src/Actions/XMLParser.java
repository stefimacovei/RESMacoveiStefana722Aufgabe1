package Actions;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class XMLParser {

    public List<Happened> parseCases(String path) throws Exception {
        List<Happened> records = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(path));
        doc.getDocumentElement().normalize(); // Normalize XML structure

        NodeList nodeList = doc.getElementsByTagName("log");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                records.add(new Happened(
                        parseIntSafe(element, "Id"),
                        getTextSafe(element, "Charaktername"),
                        getTextSafe(element, "Stufe"),
                        getTextSafe(element, "Beschreibung"),
                        getTextSafe(element, "Datum"),
                        getTextSafe(element, "Kraftpunkte")
                ));
            }
        }
        return records;
    }

    private int parseIntSafe(Element element, String tagName) {
        String text = getTextSafe(element, tagName);
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0; // Default value if parsing fails
        }
    }

    private String getTextSafe(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent().trim();
        }
        return ""; // Default empty string if element is missing
    }
}
