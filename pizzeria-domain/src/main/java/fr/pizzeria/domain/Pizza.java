package fr.pizzeria.domain;

import java.lang.reflect.Field;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@ToString(TopUpperCase = true)
	private String code;
	@ToString(TopUpperCase = false)
	private String nom;
	@ToString(TopUpperCase = false)
	private double prix;
	@Enumerated(EnumType.STRING)
	@ToString(TopUpperCase = true)
	private CategoriePizza categorie;
	@Transient
	private String url_image;
	@Transient
	private static int nbrPizza = 0; // enlever ?
	@Transient
	private static int generateId = 0; // ID unique

	public Pizza() {
//		this.id = generateId++;
//		nbrPizza++;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		this.id = generateId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categoriePizza;
		nbrPizza++;
	}

	public static int getNbrPizza() {
		return nbrPizza;
	}

	public static void setNbrPizza(int nbrPizza) {
		Pizza.nbrPizza = nbrPizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categorie;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categorie = categoriePizza;
	}

	@Override
	public String toString() {

		String resultat = "";

		for (Field field : this.getClass().getDeclaredFields()) {

			ToString annotation = field.getAnnotation(ToString.class);
			if (annotation != null) {
				boolean toUpperCase = annotation.TopUpperCase();
				try {
					if (toUpperCase) {

						resultat += field.get(this).toString().toUpperCase();

					} else {
						resultat += field.get(this);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}

		return "Cette pizza est de catégorie : " + categorie;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

}
