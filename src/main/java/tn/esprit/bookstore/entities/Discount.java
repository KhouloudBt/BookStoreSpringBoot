package tn.esprit.bookstore.entities;

import javax.persistence.Entity;

@Entity
public class Discount extends Promition{

    private float newPrice;

    private float oldPrice;

    private float percentage;

    public Discount() {
        super();
    }

    public Discount(Book book, float newPrice, float oldPrice, float percentage) {
        super(book,"Discount");
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.percentage = percentage;
    }

    public float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(float newPrice) {
        this.newPrice = newPrice;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "newPrice=" + newPrice +
                ", oldPrice=" + oldPrice +
                ", percentage=" + percentage +
                '}';
    }
}
