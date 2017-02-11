package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact information in the address book. Guarantees:
 * immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Contact {

	public String value;
	protected boolean isPrivate;

	 /**
     * Validates given contact information.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
	
	public Contact(String address, boolean isPrivate, String contactTypeValidationRegex, String contactTypeConstraints) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedAddress, contactTypeValidationRegex)) {
            throw new IllegalValueException(contactTypeConstraints);
        }
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidContact(String test, String contactTypeValidationRegex) {
        return test.matches(contactTypeValidationRegex);
    }
    
	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
