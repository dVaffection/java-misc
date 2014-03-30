package vendingmachine;

import java.util.*;

public class VendingMachine {

    private State state;

    public VendingMachine() {
        changeState(new IdleState(this, new Storage(), new Till()));
    }

    void changeState(State state) {
        this.state = state;
    }

    public void fill(Collection<Product> products) {
//        storage.addProducts(products);
    }

    public void credit(Collection<Coin> coins) {

    }

    public void choose(String name) {

    }

}
