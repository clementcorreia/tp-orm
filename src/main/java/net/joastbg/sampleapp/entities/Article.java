package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Describes an Article
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
public abstract class Article implements Serializable, Comparable<Article> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2950938335694212226L;


	private Long idArticle;

	private Float price;

	private String description;
	
	public Article() {
		
	}

	public Article(String description, Float price) throws IllegalArgumentException {
		if (description == null || description.isEmpty() || price == null) {
			throw new IllegalArgumentException("Description nor price must not be empty");
		}
		setPrice(price);
		setDescription(description);
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String firstName) {
		this.description = firstName;
	}

	@Override
	public int compareTo(Article o) {
		return o.getDescription().compareTo(this.getDescription()) + o.getPrice().compareTo(this.getPrice());
	}
	
}
