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

/**
 * The persistent class for the tuser database table.
 * 
 */
@Entity
@Table(name = "tuser")
@NamedQuery(name = "Tuser.findAll", query = "SELECT t FROM Tuser t")
public class Tuser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	private String lastName;

	private String modificaionDate;

	private String password;

	private String registrationDate;

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