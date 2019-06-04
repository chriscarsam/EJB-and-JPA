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

import com.sambcode.app.appwebschedule.MyHelper;
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

	private String passwordRepeat;

	public EjbUser() {
		user = new Tuser();
	}

	@Override
	public Map<String, String> insert() {

		Map<String, String> returnMap = new HashMap<String, String>();

		try {

			String generalMessage = "";

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String currentDate = sdf.format(new Date());

			user.setRegistrationDate(currentDate);
			user.setModificaionDate(currentDate);

			if (!user.getPassword().equals(passwordRepeat)) {
				generalMessage += "Password do not match";
				System.out.println("Password do not match <br>");
			}

			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();

			Set<ConstraintViolation<Tuser>> constrain = validator.validate(user);

			for (ConstraintViolation<Tuser> item : constrain) {
				generalMessage += item.getMessage() + "<br>";

			}

			user.setPassword(new MyHelper().encrypt(user.getPassword()));

			IDaoUser iDaoUser = new DaoUser();

			emf = Persistence.createEntityManagerFactory("appwebschedule");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			if (iDaoUser.getByEmail(em, user.getEmail()) != null) {

				generalMessage += "The email was previously registered <br>";

			}

			if (!generalMessage.equals("")) {

				et.rollback();

				returnMap.put("correct", "No");
				returnMap.put("generalMessage", generalMessage);

				return returnMap;
			}

			iDaoUser.insert(em, user);
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

	@Override
	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	@Override
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

}
