// Gavin Lo
// 05-18-2017
// This program represents the contact information of a person.

public class Contact
{
	String name, relation, bday, phone, email;

	// Constructor
	public Contact(String name, String relation, String bday, String phone, String email) {
		this.name = name;
		this.relation = relation;
		this.bday = bday;
		this.phone = phone;
		this.email = email;
	}

	// Getters
	public String getName() {
		return name;
	}
	public String getRelation() {
		return relation;
	}
	public String getBDay() {
		return bday;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	// ToString method
	public String toString() {
		if (this.name.length() < 10) {
			return name + "   \t" + relation + "\t" + bday + "\t" + phone + "\t" + email;
		}
		return name + "\t" + relation + "\t" + bday + "\t" + phone + "\t" + email;
	}
}
