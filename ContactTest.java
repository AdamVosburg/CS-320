import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
    /**
     * Tests the creation of a valid Contact object.
     * Verifies that the constructor sets the fields correctly.
     */
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertNotNull(contact);
        Assertions.assertEquals("1234567890", contact.getContactId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    /**
     * Tests the creation of a Contact object with an invalid contact ID.
     * Verifies that an IllegalArgumentException is thrown when the contact ID is too long.
     */
    @Test
    public void testContactIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with an invalid first name.
     * Verifies that an IllegalArgumentException is thrown when the first name is too long.
     */
    @Test
    public void testFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with an invalid last name.
     * Verifies that an IllegalArgumentException is thrown when the last name is too long.
     */
    @Test
    public void testLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with an invalid phone number.
     * Verifies that an IllegalArgumentException is thrown when the phone number is not 10 digits.
     */
    @Test
    public void testPhoneInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with an invalid address.
     * Verifies that an IllegalArgumentException is thrown when the address is too long.
     */
    @Test
    public void testAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St, Apt 456, City, State, Country");
        });
    }

    /**
     * Tests the creation of a Contact object with a null contact ID.
     * Verifies that an IllegalArgumentException is thrown when the contact ID is null.
     */
    @Test
    public void testContactIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with a null first name.
     * Verifies that an IllegalArgumentException is thrown when the first name is null.
     */
    @Test
    public void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with a null last name.
     * Verifies that an IllegalArgumentException is thrown when the last name is null.
     */
    @Test
    public void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with a null phone number.
     * Verifies that an IllegalArgumentException is thrown when the phone number is null.
     */
    @Test
    public void testPhoneNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
    }

    /**
     * Tests the creation of a Contact object with a null address.
     * Verifies that an IllegalArgumentException is thrown when the address is null.
     */
    @Test
    public void testAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
    }
}