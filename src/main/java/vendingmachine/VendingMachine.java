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

    public void fillWithProducts(Collection<Product> products) throws StateException {
        state.fillWithProducts(products);
    }

    public void credit(Collection<Coin> coins) throws StateException {
        state.credit(coins);
    }

    public void chooseProduct(String name) throws TillException, StateException {
        state.chooseProduct(name);
    }

    public Product getProduct() throws StateException {
        return state.getProduct();
    }

    public Collection<Coin> getChange() throws StateException {
        return state.getChange();
    }

}
