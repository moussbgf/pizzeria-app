package org.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.exception.StockageException;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;

public class PizzaDaoImplJdbc implements IPizzaDao {

	private static final String URL = "jdbc:mysql://localhost:3306/pizzeria?useSSL=false";
	private static final String USER = "root";
	private static final String PWD = "";

	private static boolean driverLoaded = false;

	public PizzaDaoImplJdbc() {

		if (driverLoaded == false) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Pizza> findAllPizzas() {

		Connection myConnection;
		
		List<Pizza> listPizzas = null;
		
		try {
			myConnection = DriverManager.getConnection(URL, USER, PWD);

			Statement statement = myConnection.createStatement();

			ResultSet resultat = statement.executeQuery("select * from pizza");

			// System.out.println("\t id" + "\t nom" + "\t prix");
			//
			// while (resultat.next()) {
			//
			// System.out.println("\t" + resultat.getInt("id") + "\t" +
			// resultat.getString("nom") + "\t"
			// + resultat.getDouble("prix") + "\n");
			// }

			 listPizzas = new ArrayList<Pizza>();

			while (resultat.next()) {

				Pizza p = new Pizza();

				p.setCode(resultat.getString("code"));
				p.setId(resultat.getInt("id"));
				p.setNom(resultat.getString("nom"));
				p.setPrix(resultat.getDouble("prix"));
				p.setCategoriePizza(CategoriePizza.valueOf(resultat.getString("categorie")));

				listPizzas.add(p);

			}

			statement.close();
			resultat.close();
			myConnection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPizzas;

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {

		try {
			Connection myConnection = DriverManager.getConnection(URL, USER, PWD);

			PreparedStatement updatePizzaSt = myConnection
					.prepareStatement("INSERT INTO pizza (code, nom, prix, categorie) values (?,?,?,?)");

			updatePizzaSt.setString(1, pizza.getCode());

			updatePizzaSt.setString(2, pizza.getNom());

			updatePizzaSt.setDouble(3, pizza.getPrix());

			CategoriePizza categorie = pizza.getCategoriePizza();

			updatePizzaSt.setString(4, categorie.toString().toUpperCase());

			if (updatePizzaSt.executeUpdate() == 0) {

				System.out.println("La pizza n'a pas été ajouté !");

			}

			updatePizzaSt.close();
			myConnection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws StockageException {

		Connection myConnection;
		try {
			myConnection = DriverManager.getConnection(URL, USER, PWD);

			PreparedStatement updatePizzaSt = myConnection
					.prepareStatement("INSERT INTO pizza (code, nom, prix, categorie) values (?,?,?,?)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePizza(String codePizza) throws StockageException {

		// gerer les clés étranére

		Connection myConnection;
		try {

			myConnection = DriverManager.getConnection(URL, USER, PWD);

			PreparedStatement updatePizzaSt = myConnection.prepareStatement("DELETE from pizza where code = ? ");

			updatePizzaSt.setString(1, codePizza);

			if (updatePizzaSt.executeUpdate() == 0) {

				System.out.println("La pizza n'a pas été suprimé ou n'existe pas !");

			}

			updatePizzaSt.close();
			myConnection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
