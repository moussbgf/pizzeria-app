package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.domain.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {
	
	public ListerPizzaOptionMenu(IPizzaDao stockage) {
		super(stockage);
		this.titre = "Liste des pizzas";
	}

	@Override
	public void execute() throws SQLException {
		
		List<Pizza> listPizza = stockage.findAllPizzas();
		System.out.println("\nIl y a " + Pizza.getNbrPizza() + " Pizza stocké.\n");
		
		System.out.println("\nListe des pizzas : \n");
		
		if(stockage == null){
		}else {
			
			for (int i = 0; i < listPizza.size(); i++) {
				if (listPizza.get(i) != null && listPizza.get(i).getId() != -1) {
					System.out.println(listPizza.get(i).getId() + " " + listPizza.get(i).getCode() + " " + listPizza.get(i).getNom() + " " + listPizza.get(i).getPrix() + " " + listPizza.get(i).getCategoriePizza());
				}
			}
		}
	}

}
