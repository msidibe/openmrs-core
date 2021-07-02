/**
 * openmrs-core
 * <p>
 * User: msidibe
 * Date: 2021-07-02
 * <p>
 * This code is copyright (c) 2021 let's dev.
 * URL: http://www.letsdev.de
 * e-Mail: contact@letsdev.de
 */

package org.openmrs.helper;

import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonName;

public class PersonHelper {

	public static void setPreferredPersonAddress(Person person) {
		PersonAddress preferredAddress = null;
		PersonAddress possiblePreferredAddress = person.getPersonAddress();
		if (possiblePreferredAddress != null && possiblePreferredAddress.getPreferred()
			&& !possiblePreferredAddress.getVoided()) {
			preferredAddress = possiblePreferredAddress;
		}

		for (PersonAddress address : person.getAddresses()) {
			if (preferredAddress == null && !address.getVoided()) {
				address.setPreferred(true);
				preferredAddress = address;
				continue;
			}

			if (!address.equals(preferredAddress)) {
				address.setPreferred(false);
			}
		}
	}

	public static void setPreferredPersonName(Person person) {
		PersonName preferredName = null;
		PersonName possiblePreferredName = person.getPersonName();
		if (possiblePreferredName != null && possiblePreferredName.getPreferred() && !possiblePreferredName.getVoided()) {
			preferredName = possiblePreferredName;
		}

		for (PersonName name : person.getNames()) {
			if (preferredName == null && !name.getVoided()) {
				name.setPreferred(true);
				preferredName = name;
				continue;
			}

			if (!name.equals(preferredName)) {
				name.setPreferred(false);
			}
		}
	}
}
