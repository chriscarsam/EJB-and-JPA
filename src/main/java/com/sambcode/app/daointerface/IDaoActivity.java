package com.sambcode.app.daointerface;

import java.util.List;

import javax.persistence.EntityManager;

import com.sambcode.app.entity.Tactivity;

public interface IDaoActivity {
	public boolean insert(EntityManager em, Tactivity activity) throws Exception;

	public List<Tactivity> getByIdUser(EntityManager em, int idUser) throws Exception;

	public List<Tactivity> getByIdUserAndState(EntityManager em, int idUser, boolean state) throws Exception;
}
