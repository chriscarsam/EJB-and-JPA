package com.sambcode.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sambcode.app.daointerface.IDaoActivity;
import com.sambcode.app.entity.Tactivity;

public class DaoActivity implements IDaoActivity {

	@Override
	public boolean insert(EntityManager em, Tactivity activity) throws Exception {
		em.persist(activity);

		return true;
	}

	@Override
	public List<Tactivity> getByIdUser(EntityManager em, int idUser) throws Exception {
		TypedQuery<Tactivity> query = em.createNamedQuery("Tactivity.getByIdUser", Tactivity.class);

		query.setParameter("idUser", idUser);

		return query.getResultList();
	}

	@Override
	public List<Tactivity> getByIdUserAndState(EntityManager em, int idUser, boolean state) throws Exception {
		TypedQuery<Tactivity> query = em.createNamedQuery("Tactivity.getByIdUserAndState", Tactivity.class);

		query.setParameter("idUser", idUser);
		query.setParameter("state", state);

		return query.getResultList();
	}

	@Override
	public Tactivity getByIdActivity(EntityManager em, int idActivity) throws Exception {

		return em.find(Tactivity.class, idActivity);
	}

	@Override
	public boolean changeStatus(EntityManager em, Tactivity activity) throws Exception {

		em.merge(activity);

		return true;
	}

}
