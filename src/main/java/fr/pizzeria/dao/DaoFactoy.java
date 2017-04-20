package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;

public interface DaoFactoy {
	
	public IPizzaDao getPizzaDao();
}
