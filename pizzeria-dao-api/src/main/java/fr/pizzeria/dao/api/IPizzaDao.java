package fr.pizzeria.dao.api;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.dao.api.exception.StockageException;
import fr.pizzeria.domain.Pizza;

public interface IPizzaDao {

	// Pizza[] findAllPizzas();

	List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza) throws StockageException;

	void updatePizza(String codePizza, Pizza pizza) throws StockageException;

	void deletePizza(String codePizza) throws StockageException;

	int existPizza(String codeATester);

}
