package fr.pizzeria.dao.fichier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.exception.DeletePizzaException;
import fr.pizzeria.dao.api.exception.SavePizzaException;
import fr.pizzeria.dao.api.exception.StockageException;
import fr.pizzeria.dao.api.exception.UpdatePizzaException;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {

	public PizzaDaoImplFichier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> listPizzas;
		try (Stream<Path> list = Files.list(Paths.get("data")); ) {
			listPizzas = list.map(path -> {

				String code = path.toFile().getName().replaceAll(".txt", "");

				String[] valueTab;
				try (Stream<String> list2 = Files.lines(path)) {
					valueTab = list2.findFirst().orElseThrow(() -> new StockageException("fichier vide"))
							.split(";");
				} catch (IOException e) {
					throw new StockageException(e);
				}

				return new Pizza(code, valueTab[1], Double.valueOf(valueTab[2]), CategoriePizza.valueOf(valueTab[3]));

			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}

		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		String pizzaData = "";

		if (pizza.getCategoriePizza().equals(CategoriePizza.SANS_VIANDE)) {

			pizzaData = pizza.getCode() + ";" + pizza.getNom() + ";" + pizza.getPrix() + ";" + "SANS_VIANDE";

		} else {
			pizzaData = pizza.getCode() + ";" + pizza.getNom() + ";" + pizza.getPrix() + ";"
					+ pizza.getCategoriePizza().toString().toUpperCase() + "\n";
		}

		byte[] bytes = pizzaData.getBytes();

		Path path = Paths.get(DaoFichierFactory.getDataDir()+ "\\" + pizza.getCode());

		try {
			Files.write(path, bytes);
		} catch (IOException e) {
			throw new SavePizzaException(e);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		deletePizza(codePizza);
		
		saveNewPizza(pizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {

		Path path = Paths.get(DaoFichierFactory.getDataDir() + "\\" + codePizza);

		try {
			Files.delete(path);
		} catch (IOException e) {
			throw new DeletePizzaException(e);
		}

	}

	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
