package org.pizzeria.dao.jdbc;

import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;

/**
 * Hello world!
 *
 */
public class DaoJdbcFactory implements DaoFactoy {

	private IPizzaDao pizzaDao = new PizzaDaoImplJdbc();

	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;

	}

}
