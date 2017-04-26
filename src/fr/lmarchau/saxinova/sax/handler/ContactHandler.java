package fr.lmarchau.saxinova.sax.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.lmarchau.saxinova.model.Contact;

/**
 * SAX handler extract contacts from xml fragments
 *
 * WARN: This implementation ignore unknown tags
 */
public class ContactHandler extends DefaultHandler {

	private List<Contact> contacts;

	private Stack<Contact> contactStack;

	String content;

	public ContactHandler() {
		contacts = new ArrayList<>();
		contactStack = new Stack<>();
		content = null;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		content = null;
		switch(qName) {
			case "contact":
				Contact contact = new Contact();
				// extract id attribut if exists
				if (attributes != null && attributes.getValue("id") != null) {
					contact.setId(Long.valueOf(attributes.getValue("id")));
				}
				// add contact to default statck
				contactStack.push(contact);
				break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
			case "contact":
				// get current contact
				Contact contact = contactStack.pop();
				// add to global contacts list if statck is empty
				if (contactStack.empty()) {
					contacts.add(contact);
				}
				// add to parent contacts list
				else {
					Contact parent = contactStack.peek();
					parent.addContact(contact);
				}
				break;
			case "id":
				contactStack.peek().setId(Long.valueOf(content));
				break;
			case "lastName":
				contactStack.peek().setLastName(content);
				break;
			case "name":
				contactStack.peek().setName(content);
				break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// extract and trim value
		content = String.valueOf(ch, start, length).trim();
	}
}
