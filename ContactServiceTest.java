/**
 * Unit tests for the ContactService class.
 * Verifies the behavior of the ContactService class and its methods.
 * Author: Adam Vosburg
 * Date: 03/26/2024
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ContactServiceTest {
    private ContactService contactService;

    /**
     * Sets up a new ContactService instance before each test.
     */
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    /**
     * Tests adding a contact to the ContactService.
     * Verifies that the contact can be retrieved after being added.
     */
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact("1234567890");
        Assertions.assertEquals(contact, retrievedContact);
    }

    /**
     * Tests adding a duplicate contact to the ContactService.
     * Verifies that an IllegalArgumentException is thrown when adding a contact with an existing ID.
     */
    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    /**
     * Tests deleting a contact from the ContactService.
     * Verifies that the contact cannot be retrieved after being deleted.
     */
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("1234567890");
        });
    }

    /**
     * Tests deleting a non-existent contact from the ContactService.
     * Verifies that an IllegalArgumentException is thrown when deleting a contact with a non-existent ID.
     */
    @Test
    public void testDeleteNonexistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567890");
        });
    }

    /**
     * Tests updating a contact in the ContactService.
     * Verifies that the contact is updated with the new values.
     */
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
        Contact updatedContact = contactService.getContact("1234567890");
        Assertions.assertEquals("Jane", updatedContact.getFirstName());
        Assertions.assertEquals("Smith", updatedContact.getLastName());
        Assertions.assertEquals("9876543210", updatedContact.getPhone());
        Assertions.assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    /**
     * Tests updating a non-existent contact in the ContactService.
     * Verifies that an IllegalArgumentException is thrown when updating a contact with a non-existent ID.
     */
    @Test
    public void testUpdateNonexistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
        });
    }

    /**
     * Tests adding a null contact to the ContactService.
     * Verifies that a NullPointerException is thrown when adding a null contact.
     */
    @Test
    public void testAddNullContact() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            contactService.addContact(null);
        });
    }

    /**
     * Tests deleting a contact with a null ID from the ContactService.
     * Verifies that an IllegalArgumentException is thrown when deleting a contact with a null ID.
     */
    @Test
    public void testDeleteContactWithNullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    /**
     * Tests updating a contact with a null ID in the ContactService.
     * Verifies that an IllegalArgumentException is thrown when updating a contact with a null ID.
     */
    @Test
    public void testUpdateContactWithNullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact(null, "Jane", "Smith", "9876543210", "456 Oak Ave");
        });
    }
}