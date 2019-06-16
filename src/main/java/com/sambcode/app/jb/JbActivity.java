package com.sambcode.app.jb;

import java.io.Serializable;

public class JbActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idActivity;
	private int idUser;
	private String firstName;
	private String description;
	private boolean state;
	private String dateStartTime;
	private String endTimeDate;
	private String registrationDate;
	private String modificationDate;
	private String place;

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateStartTime() {
		return dateStartTime;
	}

	public void setDateStartTime(String dateStartTime) {
		this.dateStartTime = dateStartTime;
	}

	public String getEndTimeDate() {
		return endTimeDate;
	}

	public void setEndTimeDate(String endTimeDate) {
		this.endTimeDate = endTimeDate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
