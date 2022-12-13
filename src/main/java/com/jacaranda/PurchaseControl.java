package com.jacaranda;
import java.util.List;
import org.hibernate.query.Query;

public class PurchaseControl {


public static List<Purchase> getPurchase(){
	List<Purchase> purchases = null; 
	
	Query<Purchase> query = ConnectionDAO.getSession().createQuery("SELECT k FROM com.jacaranda.Purchase k");
	purchases = (List<Purchase>)query.getResultList();
	
	return purchases;
}



//public static boolean addPurchase(List<CartItem> cartList) {
//	boolean result = false; 
//	
//		if(cartList.size() > 0) {
//			
//			ConnectionDAO.getSession().getTransaction().begin();
//
//			Iterator<CartItem> iterator = cartList.iterator();
//			
//			while(iterator.hasNext()) {
//				CartItem iItem = iterator.next();
//				
//				//checking if the user and element exist in DB
//				Element ele = ElementControl.getElement(iItem.getElementId());
//				User user = UserControl.getUser(iItem.getUserId());
//				
//				//checking that stock if greater than quantity
//				if (ele.getStock() >= iItem.getQuantity()) {
//					int newStock = ele.getStock() - iItem.getQuantity();
//					Sale newSale = new Sale(ele, user, iItem.getOrderedDate(), iItem.getQuantity(), iItem.getPrice()) ;
//					ConnectionDAO.getSession().save(newSale);
//					ele.setStock(newStock);
//					ConnectionDAO.getSession().save(ele);
//					
//				}else {
//					throw new SaleControlException("La cantidad no puede ser mayor que el stock disponible.");
//				}
//				
//			}
//			
//			ConnectionDAO.getSession().getTransaction().commit();
//			result = true;
//			
//		} else {
//			throw new SaleControlException("La lista de productos está vacía.");
//		}
//		
//	return result;
//}
//		


}