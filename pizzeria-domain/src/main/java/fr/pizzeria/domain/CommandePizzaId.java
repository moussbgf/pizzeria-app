package fr.pizzeria.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CommandePizzaId implements Serializable {
	
//	@Column(name="id_commadne")
	
	private int id_commande;
//	@Column(name="id_pizza")
	private int id_pizza;
	
	public int getIdCommande() {
		return id_commande;
	}


	public void setIdCommande(int idCommande) {
		this.id_commande = idCommande;
	}


	public int getIdPizza() {
		return id_pizza;
	}


	public void setIdPizza(int idPizza) {
		this.id_pizza = idPizza;
	}
}
