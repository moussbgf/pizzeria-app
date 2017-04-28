package fr.pizzeria.domain;

import javax.persistence.*;

@Entity
@Table (name="commande_pizza")
public class CommandePizza {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Embedded
	CommandePizzaId cmd;
	
	@Column(name="quantite")
	private int quantite;
	
//	@ManyToOne
//	@JoinColumn(name="id_commande")
//	private Commande commande;
//	
//	@ManyToOne
//	@JoinColumn(name="id_pizza")
//	private Pizza pizza;
	
	
	public CommandePizza() {
		super();
		
	}


	public CommandePizzaId getCmd() {
		return cmd;
	}


	public void setCmd(CommandePizzaId cmd) {
		this.cmd = cmd;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


//	public Commande getCommande() {
//		return commande;
//	}
//
//
//	public void setCommande(Commande commande) {
//		this.commande = commande;
//	}
	
	
	
}
