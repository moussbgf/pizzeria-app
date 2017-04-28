package fr.pizzeria.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="commande_pizza")
public class CommandePizza {
	
	@Embedded
	CommandePizzaId cmd;
	@Column(name="quantite")
	private int quantite;
	
	
	public CommandePizza() {
		super();
		
	}


	
	
	
	
	
}
