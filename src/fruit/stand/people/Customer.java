package fruit.stand.people;

public class Customer extends Person {
    public Customer(String name, double cash) {
        super(name, cash);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }
}
