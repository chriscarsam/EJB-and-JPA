package com.sambcode.app.ejbinterface;

import java.util.List;

import javax.ejb.Local;

import com.sambcode.app.entity.Tuser;

@Local
public interface IEjbUser {
	public boolean insert();

	public void setListUser(List<Tuser> listTuser);

	public List<Tuser> getListUser();

	public void setUser(Tuser user);

	public Tuser getUser();

	public String getPasswordRepeat();

	public void setPasswordRepeat(String passwordRepeat);
}
