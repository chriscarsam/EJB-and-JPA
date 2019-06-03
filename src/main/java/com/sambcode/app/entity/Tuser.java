package com.sambcode.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The persistent class for the tuser database table.
 * 
 */
@Entity
@Table(name = "tuser")
@NamedQuery(name = "Tuser.getByEmail", query = "SELECT t FROM Tuser t WHERE t.email=:email")
public class Tuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@NotNull(message = "The \"Email\" field is required")
	@Size(min = 6, max = 700, message = "The \"Email\" field must have the length between 6-700")
	@Pattern(regexp = "[a-zA-Z0-9\\.\\-\\_]+\\@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}", message = "The \"Email\" field does not comply with the proper format example: example@gmail.com")
	private String email;

	@NotNull(message = "The \"First Name\" field is required")
	@Size(min = 1, max = 70, message = "The \"First Name\" field must have the length between 1-70")
	private String firstName;

	@NotNull(message = "The \"Last Name\" field is required")
	@Size(min = 1, max = 40, message = "The \"Last Name\" field must have the length between 1-40")
	private String lastName;

	@NotNull(message = "The \"Modification Date\" field is required")
	@Pattern(regexp = "\\d{4}\\/\\d{2}\\/\\d{2}\\s\\d{2}\\:\\d{2}\\:\\d{2}", message = "The \"Modification Date\" field does not comply with the proper format example: yyyy/mm/dd hh:mm:ss")
	private String modificaionDate;

	@NotNull(message = "The \"Password\" field is required")
	@Size(min = 4, max = 700, message = "The \"Password\" field must have the length between 4-700")
	private String password;

	@NotNull(message = "The \"Registration Date\" field is required")
	@Pattern(regexp = "\\d{4}\\/\\d{2}\\/\\d{2}\\s\\d{2}\\:\\d{2}\\:\\d{2}", message = "The \"Registration Date\" field does not comply with the proper format example: yyyy/mm/dd hh:mm:ss")
	private String registrationDate;

	@NotNull(message = "The \"Date of birth\" field is required")
	@Pattern(regexp = "\\d{4}\\-\\d{2}\\-\\d{2}", message = "The \"Date of birth\" field does not comply with the proper format example: mm/dd/yyyy")
	private String birthdate;

	// bi-directional many-to-one association to Tactivity
	@OneToMany(mappedBy = "tuser")
	private List<Tactivity> tactivities;

	public Tuser() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getModificaionDate() {
		return this.modificaionDate;
	}

	public void setModificaionDate(String modificaionDate) {
		this.modificaionDate = modificaionDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public List<Tactivity> getTactivities() {
		return this.tactivities;
	}

	public void setTactivities(List<Tactivity> tactivities) {
		this.tactivities = tactivities;
	}

	public Tactivity addTactivity(Tactivity tactivity) {
		getTactivities().add(tactivity);
		tactivity.setTuser(this);

		return tactivity;
	}

	public Tactivity removeTactivity(Tactivity tactivity) {
		getTactivities().remove(tactivity);
		tactivity.setTuser(null);

		return tactivity;
	}

}