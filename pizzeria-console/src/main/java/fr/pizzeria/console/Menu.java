package fr.pizzeria.console;

import java.util.Map;

public class Menu {
	
	private Map<Integer,OptionMenu> actions;

	public void afficher() {
		
//		String welcome = FigletFont.convertOneLine("Pizzeria App");
//	    System.out.println(welcome);
		
		
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("5. Importer les données");
		System.out.println("99. Sortir\n");
	}
	
	
	public Map<Integer,OptionMenu> getActions() {
		return actions;
	}

	public void setActions(Map<Integer,OptionMenu> actions) {
		this.actions = actions;
	}
}
