package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstName;
	public String lastName;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String birthday;
	public String birthmonth;
	public String birthyear;
	public String address2;
	public String phone2;
	//public String fullName;

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address,
			String home, String mobile, String work, String email,
			String email2, String birthday, String birthmonth,
			String birthyear, String address2, String phone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		//this.fillFullName();
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.birthday = birthday;
		this.birthmonth = birthmonth;
		this.birthyear = birthyear;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", home="
	        + home + ", mobile=" + mobile + ", work=" + work + ", email=" + email + ", email2=" + email2 + ", birthday="
			+ birthday + ", birthmonth=" + birthmonth + ", birthyear=" + birthyear + ", address2=" + address2 + ", phone2="
			+ phone2 + "]";
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}

	//public void fillFullName() {
	//	this.fullName = this.firstName + " " + this.lastName;
	//}
		
}