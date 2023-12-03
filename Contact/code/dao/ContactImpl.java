package dao;

import model.Contact;

import java.util.Iterator;
import java.util.TreeSet;

public class ContactImpl implements ContactsBook, Iterable<Contact> {
    private TreeSet<Contact> contactTreeSet;
    int capacity;

    public ContactImpl(int capacity){
        this.capacity = capacity;
        this.contactTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addContact(Contact contact) {
        return contact != null && contactTreeSet.size()<capacity ? contactTreeSet.add(contact) : false;
    }

    @Override
    public Contact findContact(String name) {
        return contactTreeSet.stream()
                .filter(c ->c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Contact removeContact(String name) {
        Contact removed = findContact(name);
        contactTreeSet.removeIf(c ->c.getName().equalsIgnoreCase(name));
        return removed ;
    }

    @Override
    public boolean addNote(Contact contact) {
        return contact != null && contactTreeSet.size()<capacity ? contactTreeSet.add(contact) : false;
    }

    @Override
    public int size() {
        return contactTreeSet.size();
    }

    @Override
    public Iterator<Contact> iterator() {
        return contactTreeSet.iterator();
    }
}
