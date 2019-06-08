package com.sambcode.app.ejbinterface;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.sambcode.app.entity.Tuser;

@Local
public interface IEjbUser {

	public Map<String, String> insert();

	public Tuser getByIdUser();

	public Map<String, String> update();

	public void setListUser(List<Tuser> listTuser);

	public List<Tuser> getListUser();

	public void setUser(Tuser user);

	public Tuser getUser();

	public String getOldPassword();

	public void setOldPassword(String oldpPassword);

	public String getNewPassword();

	public void setNewPassword(String newPassword);

	public String getPasswordRepeat();

	public void setPasswordRepeat(String passwordRepeat);

	public String getOldEmail();

	public void setOldEmail(String oldEmail);
}
