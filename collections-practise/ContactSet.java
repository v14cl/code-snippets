import java.util.*;

public class ContactSet {
    private Set<String> contacts = new HashSet<>();

    public void addContact(String name) {
        contacts.add(name);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public boolean hasContact(String name) {
        return contacts.contains(name);
    }

    public void printContacts() {
        System.out.println(contacts);
    }

    public Set<String> contactsStartingWith(char letter) {
        Set<String> result = new HashSet<>();

        contacts.forEach(contact -> {
            if (contact.charAt(0) == letter) {
                result.add(contact);
            }
        });

        return result;
    }

    public void mergeContacts(ContactSet other) {
        contacts.addAll(other.contacts);
    }
}
