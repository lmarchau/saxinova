package fr.lmarchau.saxinova.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact {

	private long id;
	private String name;
	private String lastName;

	private List<Contact> contacts;

	public Contact() {
		contacts = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contact contact = (Contact) o;
		return id == contact.id && Objects.equals(name, contact.name) && Objects.equals(lastName,
				contact.lastName) && Objects.equals(contacts, contact.contacts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lastName, contacts);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Contact{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", contacts=").append(contacts);
		sb.append('}');
		return sb.toString();
	}

}
