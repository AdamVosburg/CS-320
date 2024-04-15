

/**
 * Adam Vosburg
 * CS-320 Software Automation Testing and QA
 * 03/18/2024
 * 
 * Represents a contact object with a unique contact ID, first name, last name, phone number, and address.
 * The contact ID, first name, last name, phone number, and address are required and have specific length constraints.
 * The contact ID is not updatable once set.
 */
public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructs a new Contact object with the provided contact ID, first name, last name, phone number, and address.
     *
     * @param contactId the unique contact ID (required, max length: 10)
     * @param firstName the first name (required, max length: 10)
     * @param lastName  the last name (required, max length: 10)
     * @param phone     the phone number (required, must be 10 digits)
     * @param address   the address (required, max length: 30)
     * @throws IllegalArgumentException if any of the input parameters are invalid
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contactId");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Returns the unique contact ID.
     *
     * @return the contact ID
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name (required, max length: 10)
     * @throws IllegalArgumentException if the first name is invalid
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName");
        }
        this.firstName = firstName;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name (required, max length: 10)
     * @throws IllegalArgumentException if the last name is invalid
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName");
        }
        this.lastName = lastName;
    }

    /**
     * Returns the phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number.
     *
     * @param phone the new phone number (required, must be 10 digits)
     * @throws IllegalArgumentException if the phone number is invalid
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone");
        }
        this.phone = phone;
    }

    /**
     * Returns the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address (required, max length: 30)
     * @throws IllegalArgumentException if the address is invalid
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}