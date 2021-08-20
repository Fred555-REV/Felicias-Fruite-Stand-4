package fruit.stand.company;

import fruit.stand.people.Person;
import fruit.stand.products.Product;

public class Transaction {
    private int amount;
    private Person from;
    private Person to;
    private Product product;

    protected Transaction(int amount, Person from, Person to, Product product) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "\nTransaction{" +
                "amount=" + amount +
                ", from='" + from.getName() + '\'' +
                ", to='" + to.getName() + '\'' +
                ", product=" + product +
                '}';
    }
}
