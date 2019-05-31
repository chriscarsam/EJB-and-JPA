package com.sambcode.app.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sambcode.app.dao.DaoUser;
import com.sambcode.app.daointerface.IDaoUser;
import com.sambcode.app.ejbinterface.IEjbUser;
import com.sambcode.app.entity.Tuser;

@Stateless
public class EjbUser implements IEjbUser {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private EntityTransaction et = null;

	private Tuser user;
	private List<Tuser> listUser;

	public EjbUser() {
		user = new Tuser();
	}

	@Override
	public boolean insert() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String currentDate = sdf.format(new Date());

			user.setRegistrationDate(currentDate);
			user.setModificaionDate(currentDate);

			IDaoUser iDaoUser = new DaoUser();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			iDaoUser.insert(em, user);
			et.commit();

			return true;

		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}

			System.out.println("Error " + e.getMessage());

			return false;

		} finally {
			if (em != null) {
				em.close();
				em = null;
			}
			if (emf != null) {
				emf.close();
				emf = null;
			}

			et = null;
		}

	}

	@Override
	public Tuser getUser() {
		return user;
	}

	@Override
	public void setUser(Tuser user) {
		this.user = user;
	}

	@Override
	public List<Tuser> getListUser() {
		return listUser;
	}

	@Override
	public void setListUser(List<Tuser> listUser) {
		this.listUser = listUser;
	}

}