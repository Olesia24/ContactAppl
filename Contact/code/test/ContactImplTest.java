package test;

import dao.ContactImpl;
import dao.ContactsBook;
import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactImplTest {
    ContactsBook contactsBook;
    Contact[] contacts;

    @BeforeEach
    void setUp() {
        contactsBook = new ContactImpl(6);
        contacts = new Contact[]{
                new Contact("Anna", 12345, " "),
                new Contact("Alex", 12345, " "),
                new Contact("Martin", 12345, " "),
                new Contact("Maria", 12345, " "),
                new Contact("Irena", 12345, " "),
        };
        for (Contact contact : contacts) {
            contactsBook.addContact(contact);
        }
    }
    @Test
    void addContactTest() {
        assertFalse(contactsBook.addContact(null));
        assertFalse(contactsBook.addContact(new Contact("Anna", 12345, " ")));
        assertTrue(contactsBook.addContact(new Contact("Anna2", 12345, " ")));
        assertEquals(6, contactsBook.size());
        assertFalse(contactsBook.addContact(new Contact("Anna3", 12345, " ")));
        assertEquals(6, contactsBook.size());
    }

    @Test
    void findContactTest() {
        Contact contact = contactsBook.findContact("Martin");
        assertEquals("Martin", contact.getName());
    }

    @Test
    void removeContactTest() {
        assertEquals(new Contact("Martin", 12345, " "), contactsBook.removeContact("Martin"));
        assertEquals(4, contactsBook.size());
    }

    @Test
    void addNoteTest() {
        assertFalse(contactsBook.addNote(null));
        assertFalse(contactsBook.addNote(new Contact("Anna", 12345, " ")));
        assertTrue(contactsBook.addNote(new Contact("Anna2", 12345, " ")));
        assertEquals(6, contactsBook.size());
        assertFalse(contactsBook.addNote(new Contact("Anna3", 12345, " ")));
        assertEquals(6, contactsBook.size());
    }
}