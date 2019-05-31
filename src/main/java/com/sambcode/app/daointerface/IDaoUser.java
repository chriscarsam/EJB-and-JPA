package com.sambcode.app.daointerface;

import javax.persistence.EntityManager;

import com.sambcode.app.entity.Tuser;

public interface IDaoUser {
	public boolean insert(EntityManager em, Tuser user) throws Exception;

	public Tuser getByIdUser(EntityManager em, int idUser) throws Exception;

	public boolean update(EntityManager em, Tuser user) throws Exception;

}
