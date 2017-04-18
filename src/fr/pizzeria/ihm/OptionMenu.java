package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageList;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	
	protected Stockage stockage;
	protected Scanner question;
	protected String titre;

	
	
	public OptionMenu(Stockage stockage) {
		
		this.stockage = stockage;
		
	}
	
	public OptionMenu(fr.pizzeria.dao.Stockage stockage, Scanner question) {
		
		this.stockage = stockage;
		this.question = question;
	}
	
	String getLibelle() {
		
		return titre;
		
	}
	
	public abstract void execute();

	
	
	public Stockage getTabPizza() {
		return stockage;
	}

	public void setTabPizza(StockageList stockageTableau) {
		this.stockage = stockageTableau;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
