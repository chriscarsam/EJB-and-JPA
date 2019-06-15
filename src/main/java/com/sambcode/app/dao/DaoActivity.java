package com.sambcode.app.dao;

import javax.persistence.EntityManager;

import com.sambcode.app.daointerface.IDaoActivity;
import com.sambcode.app.entity.Tactivity;

public class DaoActivity implements IDaoActivity {

	@Override
	public boolean insert(EntityManager em, Tactivity activity) throws Exception {
		em.persist(activity);

		return true;
	}

}
