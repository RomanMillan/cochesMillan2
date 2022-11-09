package com.jacaranda;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private int idElement;
	private String puerchaseDate;
	private int amount;
	private int price;
	
	
	//constructores
	public Purchase(int amount, int price) {
		super();
		this.amount = amount;
		this.price = price;
	}

	public Purchase() {
		super();
		this.amount = 0;
		this.price = 0;
	}

	
	//getter and setter
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdElement() {
		return idElement;
	}

	public void setIdElement(int idElement) {
		this.idElement = idElement;
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

	
	//hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idElement;
		result = prime * result + idUser;
		result = prime * result + ((puerchaseDate == null) ? 0 : puerchaseDate.hashCode());
		return result;
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
		if (idElement != other.idElement)
			return false;
		if (idUser != other.idUser)
			return false;
		if (puerchaseDate == null) {
			if (other.puerchaseDate != null)
				return false;
		} else if (!puerchaseDate.equals(other.puerchaseDate))
			return false;
		return true;
	}
	
	
	
	
}
