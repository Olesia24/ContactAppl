import dao.ContactImpl;
import model.Contact;
import model.Menu;

import java.util.Scanner;

public class ContactAppl {
    public static void main(String[] args) {
        Contact contact;
        ContactImpl contactList = new ContactImpl(200);
        contactList.addContact(new Contact("Anna", 12345, " "));
        contactList.addContact(new Contact("Alex", 12345, " "));
        contactList.addContact(new Contact("Martin", 12345, " "));
        contactList.addContact(new Contact("Maria", 12345, " "));
        contactList.addContact(new Contact("Irena", 12345, " "));

        System.out.println("- Welcome to Contact Book -");
        Scanner scanner = new Scanner(System.in);
        while (true){
            Menu.printMenu();
            System.out.println("- Select an action -");
            try {
                int choice = scanner.nextInt();
                switch (choice){
                    case 1 : { //print all contacts
                        for (Contact c: contactList) {
                            System.out.println(c);
                        }
                        System.out.println("========================");
                        break;
                    }
                    case 2 : { //Find contact by name
                        System.out.println("Enter name to search");
                        String name = scanner.next().toLowerCase();
                        Contact contactResult = contactList.findContact(name);
                        if (contactResult != null) {
                            System.out.println("Contact found: " + contactResult);
                        } else {
                            System.out.println("Contact not found.");
                        }
                        System.out.println("========================");
                        break;
                    }
                    case 3 : { //Add new Contact
                        System.out.println("Enter the Name: ");
                        String name = scanner.next();
                        System.out.println("Enter the phone Number: ");
                        Long number = scanner.nextLong();
                        System.out.println("Note: ");
                        String note = scanner.next();
                        Contact newContact = new Contact(name, number, note);
                        contactList.addContact(newContact);
                        System.out.println("Contact added successfully!");
                        System.out.println("========================");
                        break;
                    }
                    case 4 : { //Delete Contact
                        System.out.println("Enter the Name of the Contact to delete: ");
                        String nameToDelete = scanner.next();
                        Contact removedContact = contactList.removeContact(nameToDelete);
                        if (removedContact != null){
                            System.out.println("Contact '" + nameToDelete + "' deleted successfully!");
                        } else {
                            System.out.println("Contact '" + nameToDelete + "' not found");
                        }
                        System.out.println("========================");
                        break;
                    }
                    case 5 : { //exit
                        Menu.exit();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(" - Wrong input, try again -");
            }
        }

    }

}
