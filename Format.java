import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Format {
    private byte[] byteData;
    private Ccollection ccollection;

    public Format(Ccollection col) {
        this.ccollection = col;
    }

    public void setByte(byte[] byteData) {
        this.byteData = byteData;
    }

    public byte[] getByte()
    {
        return byteData;
    }

    public void setCcollection()
    {
        if (byteData != null && byteData.length > 0) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new ByteArrayInputStream(byteData));

                NodeList walutaNodes = document.getElementsByTagName("pozycja");

                for (int i = 0; i < walutaNodes.getLength(); i++) {
                    Node walutaNode = walutaNodes.item(i);

                    if (walutaNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) walutaNode;

                        // Pobierz dane z elementu XML
                        String nazwa = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                        double przelicznik = Double.parseDouble(element.getElementsByTagName("przelicznik").item(0).getTextContent().replace(",", "."));
                        String kodWaluty = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                        double kurs = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",", "."));

                        // Utwórz obiekt Waluta
                        Waluta nowaWaluta = new Waluta(nazwa, przelicznik, kodWaluty, kurs);

                        // Dodaj obiekt Waluta do kolekcji
                        ccollection.addItem(nowaWaluta);
                    }
                }

                System.out.println("Przetworzono " + walutaNodes.getLength() + " walut.");

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Błąd parsowania danych XML");
            }
        } else {
            System.err.println("Brak danych z DataProvider lub wystąpił błąd w pobieraniu danych.");
        }
    }
    public Ccollection getCollection() {
        return ccollection;
    }
}
