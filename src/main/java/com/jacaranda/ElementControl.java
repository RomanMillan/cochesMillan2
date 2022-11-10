package com.jacaranda;

import java.util.List;

import org.hibernate.query.Query;

public class ElementControl {
	
	public static List<Element> getAllElements() {
			Query<Element> query = ConnectionDAO.getSession().createQuery("SELECT c FROM com.jacaranda.Element c");
			List<Element> elementList = (List <Element>) query.getResultList();
			return elementList;
	}
}