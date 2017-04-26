package fr.lmarchau.saxinova.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import fr.lmarchau.saxinova.model.Contact;
import fr.lmarchau.saxinova.sax.handler.ContactErrorHandler;
import fr.lmarchau.saxinova.sax.handler.ContactHandler;

/**
 * Parser, used to extract a contact list from an xml file
 */
public class XmlContactParser {

	/**
	 * parse file and return contacts
	 *
	 * @param file expecting file exists and is a file
	 *
	 * @return  List<Contact> extracted from input file
	 *
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public List<Contact> parse(File file) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		// init contact handler
		xmlReader.setContentHandler(new ContactHandler());
		// init error handler
		xmlReader.setErrorHandler(new ContactErrorHandler());
		xmlReader.parse(String.valueOf(file.toURI()));
		return ((ContactHandler) xmlReader.getContentHandler()).getContacts();
	}

}
