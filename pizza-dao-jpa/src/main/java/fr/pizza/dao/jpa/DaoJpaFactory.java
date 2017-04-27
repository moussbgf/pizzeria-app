package fr.pizza.dao.jpa;

import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;


public class DaoJpaFactory implements DaoFactoy {

	private IPizzaDao pizzaDao = new PizzaDaoJpa();

	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;

	}

}
