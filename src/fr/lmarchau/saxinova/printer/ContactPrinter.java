package fr.lmarchau.saxinova.printer;

import java.util.List;

import fr.lmarchau.saxinova.model.Contact;

/**
 * Printer, print contacts List
 */
public class ContactPrinter {

	private ContactPrinter() {

	}

	public static void print(List<Contact> contacts) {
		contacts.forEach(c -> {
			System.out.println("Contact: ");
			System.out.println("[" + c.getId() + "] " + c.getName() + " " + c.getLastName());
			System.out.println("Contacts: [" + c.getContacts() + "]");
		});
	}

}
