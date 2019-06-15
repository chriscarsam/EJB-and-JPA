package com.sambcode.app.daointerface;

import javax.persistence.EntityManager;

import com.sambcode.app.entity.Tactivity;

public interface IDaoActivity {
	public boolean insert(EntityManager em, Tactivity activity) throws Exception;
}
