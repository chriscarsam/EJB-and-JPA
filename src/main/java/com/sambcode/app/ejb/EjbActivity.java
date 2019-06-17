package com.sambcode.app.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sambcode.app.dao.DaoActivity;
import com.sambcode.app.daointerface.IDaoActivity;
import com.sambcode.app.ejbinterface.IEjbActivity;
import com.sambcode.app.entity.Tactivity;
import com.sambcode.app.entity.Tuser;

@Stateless
public class EjbActivity implements IEjbActivity {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private EntityTransaction et = null;

	private Tactivity activity;
	private List<Tactivity> listActivity;

	public EjbActivity() {
		activity = new Tactivity();
		activity.setTuser(new Tuser());
	}

	@Override
	public Map<String, String> insert() {

		Map<String, String> returnMap = new HashMap<String, String>();
		String generalMessage = "";

		try {
			activity.setState(false);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String currentDate = sdf.format(new Date());

			activity.setRegistrationDate(currentDate);
			activity.setModificationDate(currentDate);

			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();

			Set<ConstraintViolation<Tactivity>> constrain = validator.validate(activity);

			for (ConstraintViolation<Tactivity> item : constrain) {
				generalMessage += item.getMessage() + "<br>";
			}

			IDaoActivity iDaoActivity = new DaoActivity();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			if (!generalMessage.equals("")) {

				et.rollback();

				returnMap.put("correct", "No");
				returnMap.put("generalMessage", generalMessage);

				return returnMap;
			}

			iDaoActivity.insert(em, activity);
			et.commit();

			returnMap.put("correct", "Yes");
			returnMap.put("generalMessage", "Registration made correctly <br>");

			return returnMap;

		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}

			System.out.println("Error " + e.getMessage());

			returnMap.put("correct", "No");

			return returnMap;

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
	public void getByIdUser(int idUser) {

		try {

			IDaoActivity iDaoActivity = new DaoActivity();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			listActivity = iDaoActivity.getByIdUser(em, idUser);

			et.commit();

		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());

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
	public void getByIdUserAndState(int idUser, boolean state) {
		try {

			IDaoActivity iDaoActivity = new DaoActivity();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			listActivity = iDaoActivity.getByIdUserAndState(em, idUser, state);

			et.commit();

		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());

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
	public void changeStatusActivity(int idActivity, boolean state) {
		try {

			IDaoActivity iDaoActivity = new DaoActivity();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			activity = iDaoActivity.getByIdActivity(em, idActivity);

			activity.setState(state);

			iDaoActivity.changeStatus(em, activity);

			et.commit();

		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());

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
	public void setListActivity(List<Tactivity> listTactivity) {
		this.listActivity = listTactivity;

	}

	@Override
	public List<Tactivity> getListActivity() {
		return this.listActivity;
	}

	@Override
	public void setActivity(Tactivity activity) {
		this.activity = activity;

	}

	@Override
	public Tactivity getActivity() {
		return this.activity;
	}

}
