package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String birthday;
	private String birthmonth;
	private String birthyear;
	private String address2;
	private String phone2;
	

	public ContactData() {
	}
	
	public ContactData(String firstName, String lastName, String address,
			String home, String mobile, String work, String email,
			String email2, String birthday, String birthmonth,
			String birthyear, String address2, String phone2) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	

	public int compareTo(ContactData other) {
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
	
	public ContactData withID(String id) {
		this.id = id;
		return this;
	}
	
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBirthDay(String birthday) {
		this.birthday = birthday;
		return this;
	}

	public ContactData withBirthMonth(String birthmonth) {
		this.birthmonth = birthmonth;
		return this;
	}

	public ContactData withBirthYear(String birthyear) {
		this.birthyear = birthyear;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public String getAddress() {
		return address;
	}

	
	public String getHome() {
		return home;
	}

	
	public String getMobile() {
		return mobile;
	}

	
	public String getWork() {
		return work;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getEmail2() {
		return email2;
	}

	
	public String getBirthday() {
		return birthday;
	}

	
	public String getBirthmonth() {
		return birthmonth;
	}

	
	public String getBirthyear() {
		return birthyear;
	}

	
	public String getAddress2() {
		return address2;
	}

	
	public String getPhone2() {
		return phone2;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setBirthmonth(String birthmonth) {
		this.birthmonth = birthmonth;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
}