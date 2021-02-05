package tn.esprit.bookstore.views;

import java.util.List;

import tn.esprit.bookstore.entities.Cart;

public interface ICartService {
    public Cart saveCart(Cart c) ;
    public List<Cart> getCarts();
    public Cart updating(Cart c) ;
    public Cart empty(long id) ;
    public Cart addToCart(long cid,String isbn) ;
    public Cart removeFromCart(long cid, String isbn);
    public void deleting(long id);
}
