package com.jacaranda;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@ManyToOne
	private User user;
	@Id
	@ManyToOne
	private Element element;
	@Id
	private String puerchaseDate;
	private int amount;
	private int price;
	
	
	//constructores
	

	public Purchase() {

	}

	
	public Purchase(Element element, User user, String puerchaseDate, int amount, int price) {
		super();
		setElement(element);
		setUser(user);
		setPuerchaseDate(puerchaseDate);
		setAmount(amount);
		setPrice(price);;
	}

	//Getter and setter
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}


	public String getPuerchaseDate() {
		return puerchaseDate;
	}


	public void setPuerchaseDate(String puerchaseDate) {
		this.puerchaseDate = puerchaseDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(element, puerchaseDate, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(element, other.element) && Objects.equals(puerchaseDate, other.puerchaseDate)
				&& Objects.equals(user, other.user);
	}


	
	
	
	
	
}
