package tn.esprit.bookstore.entities;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Cart {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
/*
@OneToOne(cascade = CascadeType.ALL)
private Member client;
*/


@ManyToMany(cascade = CascadeType.ALL)
private Collection <Book> books;

private float cartPrice;


public Cart() {
	this.cartPrice=0;
	
}



public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}



public Collection<Book> getBooks() {
	return this.books;
}


public void setBooks(Collection<Book> books) {
	this.books = books;
}


public float getCartPrice() {
	return cartPrice;
}


public void setCartPrice(float cartPrice) {
	this.cartPrice = cartPrice;
}

@Override
public String toString() {
	return "Cart [id=" + id + ", products=" + books + ", cartPrice=" + cartPrice + "]";
}





}
