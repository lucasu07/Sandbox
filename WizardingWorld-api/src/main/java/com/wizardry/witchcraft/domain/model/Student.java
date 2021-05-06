package com.wizardry.witchcraft.domain.model;


/*@Entity(name = "student")*/
public class Student {
	
	public Student (Long id, String name, String familyName, String email) {
		
		 
		this.id = id;
		this.name = name;
		this.familyName = familyName;
		this.email = email;			
	}
	
	/*
	 * @id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	public Long id;
	
	/* @Column(nullable= false, length = 50) */
	public String name;
	
	public String nationalServiceNumber;
	
	public String familyName;
	
	public Boolean isMomWizard;
	
	public Boolean isDadWizard;

	public String email;
	
	public String DateBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalServiceNumber() {
		return nationalServiceNumber;
	}

	public void setNationalServiceNumber(String nationalServiceNumber) {
		this.nationalServiceNumber = nationalServiceNumber;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Boolean getIsMomWizard() {
		return isMomWizard;
	}

	public void setIsMomWizard(Boolean isMomWizard) {
		this.isMomWizard = isMomWizard;
	}

	public Boolean getIsDadWizard() {
		return isDadWizard;
	}

	public void setIsDadWizard(Boolean isDadWizard) {
		this.isDadWizard = isDadWizard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateBirth() {
		return DateBirth;
	}

	public void setDateBirth(String dateBirth) {
		DateBirth = dateBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	
	
	
}
