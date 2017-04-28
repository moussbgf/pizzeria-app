package fr.pizza.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.exception.pizza.StockageException;
import fr.pizzeria.domain.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	private EntityManagerFactory emf;

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("pizzeria");
	}

	@Override
	public List<Pizza> findAllPizzas() {

		EntityManager em = emf.createEntityManager();

		List<Pizza> listPizzas = new ArrayList<>();

		Query query = em.createQuery("select p from Pizza p");

		listPizzas = query.getResultList();

		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(pizza);
		et.commit();

		em.close();

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws StockageException {

		// EntityManager em = emf.createEntityManager();
		//
		// EntityTransaction et = em.getTransaction();
		//
		// Query query = em.createQuery("select p from Pizza p where p.code='" +
		// codePizza + "'");
		//
		// Pizza p = (Pizza) query.getSingleResult();
		//
		// et.begin();
		//
		// if (p != null) {
		//
		// em.merge(pizza);
		// }
		//
		// et.commit();
		//
		// em.close();

		EntityManager em = emf.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code=:code", Pizza.class);

		query.setParameter("code", codePizza);

		Pizza p2 = query.getResultList().get(0);

		EntityTransaction et = em.getTransaction();

		et.begin();

		if (p2 != null) {
			p2.setCode(pizza.getCode());
			p2.setNom(pizza.getNom());
			p2.setPrix(pizza.getPrix());
			p2.setCategoriePizza(pizza.getCategoriePizza());
		}

		et.commit();
		em.close();

	}

	@Override
	public void deletePizza(String codePizza) throws StockageException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code=:code", Pizza.class);

		query.setParameter("code", codePizza);

		Pizza p = query.getResultList().get(0);

		// Pizza p1 = em.find(Pizza.class, codePizza);
		et.begin();
		if (p != null) {
			em.remove(p);
		}
		et.commit();
		em.close();
	}

	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
