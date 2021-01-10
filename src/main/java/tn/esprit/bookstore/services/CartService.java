package tn.esprit.bookstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.bookstore.dao.BookRepository;
import tn.esprit.bookstore.dao.CartRepository;
import tn.esprit.bookstore.entities.Cart;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.views.ICartService;

@Service
public class CartService implements ICartService {
	
    @Autowired
	CartRepository cartRep;    
    @Autowired
	BookRepository bookRep;
    
    public Cart saveCart(Cart c) {
		//if(CartRep.findById(c.getId())==null) {
		return cartRep.save(c);
		//}
		//return null;
	}
    public List<Cart> getCarts(){
		return cartRep.findAll();
	}
    
    public Cart updating(Cart c) {
  		if(cartRep.findById(c.getId())!=null) {
  			
  		return cartRep.save(c);
  		}
  		return null;
  		
  	}
    
    public Cart empty(long id) {
    	Cart c = cartRep.findById(id);
    	c.setBooks(null);
    	c.setCartPrice(0);
		return cartRep.save(c);

  	}
    
    public Cart addToCart(long cid,String isbn) {
	if(cartRep.findById(cid)!=null) {
    	if(bookRep.findByIsbn(isbn)!=null) {
    	Cart c=cartRep.findById(cid);
    	Book p=bookRep.findByIsbn(isbn);
    	c.getBooks().add(p);
    	c.setCartPrice(c.getCartPrice()+p.getPrice());
    	return cartRep.save(c);
    	}
    	System.err.println("cant find Book with such id");
		return null;
	}
	System.err.println("cant find cart with such id");
		return null;

  	}
    
    public void deleting(long id) {
		cartRep.deleteById(id);
	}
    public void  deleteEvreything() {
    	cartRep.deleteAll();
    }
	public Cart removeFromCart(long cid, String isbn) {
		if(cartRep.findById(cid)!=null) {
	    	if(bookRep.findByIsbn(isbn)!=null) {
	    	Cart c=cartRep.findById(cid);
	    	Book p=bookRep.findByIsbn(isbn);
	    	c.getBooks().remove(p);
	    	c.setCartPrice(c.getCartPrice()-p.getPrice());
	    	return cartRep.save(c);
	    	}
	    	System.err.println("cant find Book with such id");
			return null;
		}
		System.err.println("cant find cart with such id");
			return null;

	}
}
