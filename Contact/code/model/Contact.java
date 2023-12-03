package model;

import java.util.Objects;

public class Contact implements Comparable<Contact>{
    private String name;
    private long number;
    private String notes;

    public Contact(String name, long number, String notes) {
        this.name = name;
        this.number = number;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contacts = (Contact) o;
        return name.equals(contacts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", notes=" + notes +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }
}
