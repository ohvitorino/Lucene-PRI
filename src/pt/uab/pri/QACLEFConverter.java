package pt.uab.pri;

import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class QACLEFConverter {

	public static final String FILE_LOCATION = "qaclef_pt.xml";

	public static void main(String[] args) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;

		try {
			builder = builderFactory.newDocumentBuilder();

			Document document = builder.parse(new FileInputStream(FILE_LOCATION));

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/qa/pergunta/texto";

			// read a string value
			NodeList textList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			Path file = Paths.get("docs/qa.txt");
			
			List<String> questionsList = new ArrayList<String>();
			for (int i = 0; i < textList.getLength(); i++) {
				questionsList.add(textList.item(i).getTextContent().trim());
			}
			
			Files.write(file, questionsList, Charset.forName("UTF-8"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
