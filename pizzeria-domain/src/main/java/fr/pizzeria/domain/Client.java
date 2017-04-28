package fr.pizzeria.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String mot_de_passe;
	@OneToMany(mappedBy="client")
	private Set<Commande> setCommandes;
	
	
	public Client() {
		super();
		setCommandes = new HashSet<Commande>();
	}
	
	public Set<Commande> getSetCommandes() {
		return setCommandes;
	}

	public void setSetCommandes(Set<Commande> setCommandes) {
		this.setCommandes = setCommandes;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
}
