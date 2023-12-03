package dao;

import model.Contact;

public interface ContactsBook {
    boolean addContact(Contact contact);
    Contact findContact(String name);
    Contact removeContact(String name);
    boolean addNote(Contact contact);
    int size();

}
