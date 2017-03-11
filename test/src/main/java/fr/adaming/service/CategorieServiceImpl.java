package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

/**
 * 
 * @author Vincent Bonillo
 * @see IMagasinDao
 */
@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService{

	@Autowired
	private ICategorieDao categorieDao;
	
	
	@Override
	public List<Categorie> getAllCategorie() {
	
		return categorieDao.getAllCategorie();
	}


	@Override
	public Categorie getCategorieById(long id_cat) {
		
		return categorieDao.getCategorieById(id_cat);
	}


	@Override
	public Categorie addCategorie(Categorie categorie) {
		return categorieDao.addCategorie(categorie);
	}


	@Override
	public void deleteCategorie(Categorie categorie) {
		categorieDao.deleteCategorie(categorie);
	}

	
}
