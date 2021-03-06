package fr.pizzeria.dao.api;

import fr.pizzeria.dao.api.exception.pizza.DeletePizzaException;
import fr.pizzeria.dao.api.exception.pizza.SavePizzaException;
import fr.pizzeria.dao.api.exception.pizza.UpdatePizzaException;
import fr.pizzeria.domain.Pizza;

public interface IPizzaDaoTableau {
	
	Pizza[] findAllPizzas();

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;

	boolean deletePizza(String codePizza) throws DeletePizzaException;

	int existPizza(String codeATester);

}
