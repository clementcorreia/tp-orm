package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Describes a Dvd
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
public class Dvd extends Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185080208096257030L;

	private DvdCategory category;

	private Person realisateur;

	private Set<Person> vedettes;
	
	
	public Dvd() {
		
	}
	
//	public Dvd(String title) throws IllegalArgumentException {
//		if (title == null || title.isEmpty()) {
//			throw new IllegalArgumentException("Title must not be empty");
//		}
//		setTitle(title);
//	}

	/**
	 * @return the category
	 */
	public DvdCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(DvdCategory category) {
		this.category = category;
	}

	/**
	 * @return the realisateur
	 */
	public Person getRealisateur() {
		return realisateur;
	}

	/**
	 * @param realisateur the realisateur to set
	 */
	public void setRealisateur(Person realisateur) {
		this.realisateur = realisateur;
	}

	/**
	 * @return the vedettes
	 */
	public Set<Person> getVedettes() {
		return vedettes;
	}

	/**
	 * @param vedettes the vedettes to set
	 */
	public void setVedettes(Set<Person> vedettes) {
		this.vedettes = vedettes;
	}
}
