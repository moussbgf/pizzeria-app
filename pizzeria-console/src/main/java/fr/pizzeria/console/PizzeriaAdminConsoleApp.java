package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import com.github.lalyos.jfiglet.FigletFont;
import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;


public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		/*
		 * *********************************************************************
		 * **********
		 */
		/* JDBC */
		/*
		 * *********************************************************************
		 * **********
		 */

//		Class.forName("com.mysql.jdbc.Driver");
//
//		String url = "jdbc:mysql://localhost:3306/pizzeria?useSSL=false";
//		String user = "root";
//		String pwd = "";
//
//		Connection myConnection = DriverManager.getConnection(url, user, pwd);
//
//		Statement statement = myConnection.createStatement();
//
//		ResultSet resultat = statement.executeQuery("select * from pizza");
//		
//		System.out.println("\t id"+ "\t nom" + "\t       prix");
//
//		while (resultat.next()) {
//
//			System.out.println("\t" + resultat.getInt("id") + "\t" + resultat.getString("nom") + "\t" + resultat.getDouble("prix") + "\n");
//
//		}
//		
//		System.out.println("*******************");
//		
//		PreparedStatement selectPizzaSt = myConnection.prepareStatement("select * from pizza where id = ?");
//		
//		selectPizzaSt.setInt(1, 2);
//		
//		ResultSet resultats = selectPizzaSt.executeQuery();
//		
//		while (resultat.next()) {
//
//			System.out.println(resultats.getInt(1));
//
//		}
		
		
		
		//PreparedStatement updatePizzaSt = myConnection.prepareStatement("update pizza set prix = 20 where id=? and nom=?");
		
		
		
//		System.out.println("*******************");
//		System.out.println("*******************");
//		
//		System.out.println("\n\n");
//		
//		statement.close();
//		
//		resultat.close();
//		
//		selectPizzaSt.close();
		
		/*
		 * *********************************************************************
		 * **********
		 */

		/* fichier application.properties dans /resources */
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

		Map<Integer, OptionMenu> actions;

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
			case 1: // lister

				mapActions.get(0).execute();

				break;
			case 2: // ajouter

				mapActions.get(0).execute();

				mapActions.get(1).execute();
				break;
			case 3: // modifier

				mapActions.get(0).execute();

				mapActions.get(2).execute();

				break;
			case 4: // supprimer

				mapActions.get(0).execute();

				mapActions.get(3).execute();
				break;
			default:
				break;
			}
		}

		question.close();

	}

}
