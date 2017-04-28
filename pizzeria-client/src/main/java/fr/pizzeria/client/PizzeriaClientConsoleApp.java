package fr.pizzeria.client;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import javax.persistence.Persistence;
import com.github.lalyos.jfiglet.FigletFont;
import fr.pizzeria.console.*;
import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;


public class PizzeriaClientConsoleApp {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		// geenration schema jpa
		//Persistence.generateSchema("samplePU", null);
		
		/* fichier application.properties dans /resources */
		/*configurer le profil pour choisir la factory à charger et le type de stockage choisi*/
		/* 3 profils : 1) dev (memoire) 2) prod (fichier) 3) ddb (jdbc) */
		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoFactoryChemin = bundle.getString("dao.impl");

		System.out.println("Implementation : " + daoFactoryChemin);
		
		
		
		Class<?> maClasse = Class.forName(daoFactoryChemin);

		DaoFactoy daoFactoy = (DaoFactoy) maClasse.newInstance();

		// Affichage du welcome
		String welcome = FigletFont.convertOneLine("Pizzeria App");
		System.out.println(welcome);

		Scanner question = new Scanner(System.in);
		question.useLocale(Locale.US);

		Menu menu = new Menu();

		// Stock

		IPizzaDao pizzaDao = daoFactoy.getPizzaDao();
		
		
		
		OptionMenu lister = new ListerPizzaOptionMenu(pizzaDao);
		OptionMenu ajouter = new AjouterPizzaOptionMenu(pizzaDao, question);
		OptionMenu mettreAJour = new ModifierPizzaOptionMenu(pizzaDao, question);
		OptionMenu supprimer = new SupprimerPizzaOptionMenu(pizzaDao, question);

		//Map<Integer, OptionMenu> actions;

		Map<Integer, OptionMenu> mapActions = new HashMap<Integer, OptionMenu>();

		mapActions.put(0, lister);
		mapActions.put(1, ajouter);
		mapActions.put(2, mettreAJour);
		mapActions.put(3, supprimer);

		menu.setActions(mapActions);

		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			menu.afficher();

			// Poser une question
			choixMenu = question.nextInt();

			// Analyse de la r�ponse � la question
			switch (choixMenu) {
			case 1: // S'inscrire

				mapActions.get(0).execute();

				break;
			case 2: // Se connecter

				mapActions.get(0).execute();

				mapActions.get(1).execute();
				break;
			default:
				break;
			}
		}

		question.close();

	}

}
