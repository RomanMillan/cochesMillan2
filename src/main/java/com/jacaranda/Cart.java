package com.jacaranda;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	private Set<Element> myCart;

	public Cart() {
		super();
		this.myCart = new HashSet<Element>();
	}

	public Set<Element> getMyCart() {
		return myCart;
	}

	public void setMyCart(Element myCart) {
		this.myCart.add(myCart);
	}
	
	
}
