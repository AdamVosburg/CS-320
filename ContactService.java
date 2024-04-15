
import java.util.HashMap;
import java.util.Map;

/**
 * Provides services to manage contacts, including adding, deleting, updating, and retrieving contacts.
 * The contacts are stored in an in-memory map, with the contact ID as the key.
 */
public class ContactService {
    private Map<String, Contact> contacts;

    /**
     * Constructs a new ContactService object and initializes an empty map to store contacts.
     */
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a new contact to the service.
     *
     * @param contact the contact to add
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact from the service based on the contact ID.
     *
     * @param contactId the ID of the contact to delete
     * @throws IllegalArgumentException if the contact ID does not exist
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates an existing contact in the service based on the contact ID.
     *
     * @param contactId the ID of the contact to update
     * @param firstName the new first name
     * @param lastName  the new last name
     * @param phone     the new phone number
     * @param address   the new address
     * @throws IllegalArgumentException if the contact ID does not exist
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = contacts.get(contactId);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact from the service based on the contact ID.
     *
     * @param contactId the ID of the contact to retrieve
     * @return the contact with the specified ID
     * @throws IllegalArgumentException if the contact ID does not exist
     */
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        return contacts.get(contactId);
    }
}