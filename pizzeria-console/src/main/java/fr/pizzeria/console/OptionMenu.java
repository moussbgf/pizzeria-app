package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Scanner;
import fr.pizzeria.dao.api.IPizzaDao;

public abstract class OptionMenu {
	
	protected IPizzaDao stockage;
	protected Scanner question;
	protected String titre;

	
	
	public OptionMenu(IPizzaDao stockage) {
		
		this.stockage = stockage;
		
	}
	
	public OptionMenu(IPizzaDao stockage, Scanner question) {
		
		this.stockage = stockage;
		this.question = question;
	}
	
	String getLibelle() {
		
		return titre;
		
	}
	
	public abstract void execute() throws SQLException;

	
	
	public IPizzaDao getTabPizza() {
		return stockage;
	}

	public void setTabPizza(IPizzaDao stockageTableau) {
		this.stockage = stockageTableau;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
