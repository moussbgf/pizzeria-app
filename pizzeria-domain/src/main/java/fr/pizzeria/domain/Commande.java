package fr.pizzeria.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_commande")
	private Integer numeroCommande;
	private Integer statut;
	@Column(name = "date_commande")
	private Date dateCommande;
	@Column(name = "id_livreur")
	private Integer idLivreur;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@OneToOne
	private Livreur livreur;
	@OneToMany
	@JoinColumn(name = "id_commande")
	private Set<CommandePizza> cmdPizza;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<CommandePizza> getCmdPizza() {
		return cmdPizza;
	}

	public void setCmdPizza(Set<CommandePizza> cmdPizza) {
		this.cmdPizza = cmdPizza;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(Integer idLivreur) {
		this.idLivreur = idLivreur;
	}

}
