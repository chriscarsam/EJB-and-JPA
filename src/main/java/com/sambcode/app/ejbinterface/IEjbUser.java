package com.sambcode.app.ejbinterface;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.sambcode.app.entity.Tuser;

@Local
public interface IEjbUser {

	public Map<String, String> insert();

	public Tuser getByIdUser();

	public void setListUser(List<Tuser> listTuser);

	public List<Tuser> getListUser();

	public void setUser(Tuser user);

	public Tuser getUser();

	public String getPasswordRepeat();

	public void setPasswordRepeat(String passwordRepeat);
}
