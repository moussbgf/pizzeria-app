package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(Stockage stockage) {
		super(stockage);
		this.titre = "Supprimer une pizza";
	}

	public SupprimerPizzaOptionMenu(Stockage stockage, Scanner question) {
		super(stockage, question);
		this.titre = "Supprimer une pizza";
	}

	@Override
	public void execute() {

		System.out.println("Veuillez choisir la pizza à supprimer: (code)");
		String codeAmodifier = question.next();

		try {
			stockage.deletePizza(codeAmodifier);
		} catch (StockageException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

}
