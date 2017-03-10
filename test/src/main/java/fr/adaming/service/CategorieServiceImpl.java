package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;


@Service("CategorieService")
public class CategorieServiceImpl implements ICategorieService {
	
	@Autowired
	ICategorieDao CategorieDao;
	
	public void setCategorieDao(ICategorieDao categorieDao) {
		CategorieDao = categorieDao;
	}


	@Override
	public Categorie addCategorie(Categorie Categorie) {
		return CategorieDao.addCategorie(Categorie);
	}


	@Override
	public void deleteCategorie() {
		CategorieDao.deleteCategorie();
	}


	@Override
	public Categorie getCategorieById() {
		return CategorieDao.getCategorieById();
	}


	@Override
	public List<Categorie> getAllCategorie() {
		return CategorieDao.getAllCategorie();
	}


}
