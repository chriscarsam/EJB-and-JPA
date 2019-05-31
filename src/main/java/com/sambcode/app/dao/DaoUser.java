package com.sambcode.app.dao;

import javax.persistence.EntityManager;

import com.sambcode.app.daointerface.IDaoUser;
import com.sambcode.app.entity.Tuser;

public class DaoUser implements IDaoUser {

	@Override
	public boolean insert(EntityManager em, Tuser user) throws Exception {
		em.persist(user);
		return true;
	}

	@Override
	public Tuser getByIdUser(EntityManager em, int idUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(EntityManager em, Tuser user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
