package com.sambcode.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	@Override
	public Tuser getByEmail(EntityManager em, String email) throws Exception {

		TypedQuery<Tuser> query = em.createNamedQuery("Tuser.getByEmail", Tuser.class);
		query.setParameter("email", email);

		List<Tuser> ListUser = query.setMaxResults(1).getResultList();

		if (ListUser.size() > 0) {
			return ListUser.get(0);
		}

		return null;
	}

}
