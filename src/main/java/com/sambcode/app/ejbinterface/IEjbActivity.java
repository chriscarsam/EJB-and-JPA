package com.sambcode.app.ejbinterface;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.sambcode.app.entity.Tactivity;

@Local
public interface IEjbActivity {
	public Map<String, String> insert();

	public void setListActivity(List<Tactivity> listTactivity);

	public List<Tactivity> getListActivity();

	public void setActivity(Tactivity activity);

	public Tactivity getActivity();
}
