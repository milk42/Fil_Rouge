package co.simplon.filrouge.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.type.TimestampType;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "affaire")
public class Affaire {


	public Set<Arme> getArme() {
		return arme;
	}

	public void setArme(Set<Arme> arme) {
		this.arme = arme;
	}

	public Set<Vehicule> getVehicule() {
		return vehicule;
	}

	public void setVehicule(Set<Vehicule> vehicule) {
		this.vehicule = vehicule;
	}

	public Set<Suspect> getSuspect() {
		return suspect;
	}

	public void setSuspect(Set<Suspect> suspect) {
		this.suspect = suspect;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_affaire;

	private String nom_affaire;
	private Date date_creation;
	private Date date_cloture;
	private boolean classee=false;
	private String pieces_conviction;
	//private List<Suspect> suspectsList;
	//private List<Arme> armesList;
	//private List<Vehicule> vehiculesList;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
	})
	@JoinTable(name = "affaire_arme",
	joinColumns = { @JoinColumn(name = "id_affaire") },
	inverseJoinColumns = { @JoinColumn(name = "id_arme",nullable = false, updatable = false) })
	private Set<Arme> arme = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
	})
	@JoinTable(name = "affaire_vehicule",
	joinColumns = { @JoinColumn(name = "id_affaire") },
	inverseJoinColumns = { @JoinColumn(name = "id_vehicule",nullable = false, updatable = false) })
	private Set<Vehicule> vehicule = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
	})

	@JoinTable(name = "affaire_suspect",
	joinColumns = { @JoinColumn(name = "id_affaire") },
	inverseJoinColumns = { @JoinColumn(name = "id_suspect",nullable = false, updatable = false) })
	private Set<Suspect> suspect = new HashSet<>();

	public Affaire() {

	}

	public void classer() {
		classee=!classee;	
	}

	public Long getId_affaire() {
		return id_affaire;
	}

	public void setId_affaire(Long id_affaire) {
		this.id_affaire = id_affaire;
	}

	public String getNom_affaire() {
		return nom_affaire;
	}

	public void setNom_affaire(String nom_affaire) {
		this.nom_affaire = nom_affaire;
	}










	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_cloture() {
		return date_cloture;
	}

	public void setDate_cloture(Date date_cloture) {
		this.date_cloture = date_cloture;
	}

	public String getPieces_conviction() {
		return pieces_conviction;
	}
	public void setPieces_conviction(String pieces_conviction) {
		this.pieces_conviction = pieces_conviction;
	}

	public boolean isClassee() {
		return classee;
	}
	public void setClassee(boolean classee) {
		this.classee = classee;
	}

	//	public List<Suspect> getSuspectsList() {
	//		return suspectsList;
	//	}
	//
	//	public void setSuspectsList(List<Suspect> suspectsList) {
	//		this.suspectsList = suspectsList;
	//	}
	//
	//	public List<Arme> getArmesList() {
	//		return armesList;
	//	}
	//
	//	public void setArmesList(List<Arme> armesList) {
	//		this.armesList = armesList;
	//	}
	//
	//	public List<Vehicule> getVehiculesList() {
	//		return vehiculesList;
	//	}
	//
	//	public void setVehiculesList(List<Vehicule> vehiculesList) {
	//		this.vehiculesList = vehiculesList;
	//	}
}
