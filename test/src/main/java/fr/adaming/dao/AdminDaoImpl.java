package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;


@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao {

	/**
	 * création de la SessionFactory
	 */
	@Autowired
	private SessionFactory sf;


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	@Override
	public void isExist(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Admin> getAllAdmin() {
		String req="FROM Admin";
		Session s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		return query.list();
	}

	@Override
	public Admin addAdmin(Admin admin) {
		Session s=sf.getCurrentSession();
		s.save(admin);
		return admin;
	}

	@Override
	public Admin gestionAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}





	
	
}