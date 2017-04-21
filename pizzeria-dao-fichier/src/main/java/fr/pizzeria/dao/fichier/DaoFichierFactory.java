package fr.pizzeria.dao.fichier;

import fr.pizzeria.dao.api.*;

public class DaoFichierFactory implements DaoFactoy {

	private static final String DATA_DIR = "data";
	public static String getDataDir() {
		return DATA_DIR;
	}

	private IPizzaDao pizzaDao = new PizzaDaoImplFichier();

	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;

	}
	
	
	
}
