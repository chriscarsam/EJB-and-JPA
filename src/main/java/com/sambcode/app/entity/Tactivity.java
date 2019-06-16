package com.sambcode.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tactivity database table.
 * 
 */
@Entity
@Table(name = "tactivity")
@NamedQueries({
		@NamedQuery(name = "Tactivity.getByIdUser", query = "SELECT t FROM Tactivity t WHERE t.tuser.idUser=:idUser"),
		@NamedQuery(name = "Tactivity.getByIdUserAndState", query = "SELECT t FROM Tactivity t WHERE t.tuser.idUser=:idUser and t.state=:state") })
public class Tactivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActivity;

	private String firstName;

	@Lob
	private String description;

	private String dateStartTime;

	private String endTimeDate;

	private String modificationDate;

	private String place;

	private String registrationDate;

	private boolean state;

	// bi-directional many-to-one association to Tuser
	@ManyToOne
	@JoinColumn(name = "idUser")
	private Tuser tuser;

	public Tactivity() {
	}

	public String getDateStartTime() {
		return this.dateStartTime;
	}

	public void setDateStartTime(String dateStartTime) {
		this.dateStartTime = dateStartTime;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndTimeDate() {
		return this.endTimeDate;
	}

	public void setEndTimeDate(String endTimeDate) {
		this.endTimeDate = endTimeDate;
	}

	public int getIdActivity() {
		return this.idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public String getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

}