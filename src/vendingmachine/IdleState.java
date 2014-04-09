package vendingmachine;

import java.util.*;

public class IdleState implements State {

    private VendingMachine   vendingMachine;
    private Storage          storage;
    private Till             till;
    private Product          product;
    private Collection<Coin> change;

    public IdleState(VendingMachine vendingMachine, Storage storage, Till till) {
        this.vendingMachine = vendingMachine;
        this.storage = storage;
        this.till = till;
    }

    @Override
    public void fillWithProducts(Collection<Product> products) throws StateException {
        storage.addProducts(products);
    }

    @Override
    public void credit(Collection<Coin> coins) throws StateException {
        State state = new InTransactionState(coins, vendingMachine, storage, till);
        vendingMachine.changeState(state);
    }

    @Override
    public void chooseProduct(String name) throws TillException, StateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product getProduct() throws StateException {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Collection<Coin> getChange() throws StateException {
        return change;
    }

    public void setChange(Collection<Coin> change) {
        this.change = change;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdleState idleState = (IdleState) o;

        if (change != null ? !change.equals(idleState.change) : idleState.change != null) return false;
        if (product != null ? !product.equals(idleState.product) : idleState.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (change != null ? change.hashCode() : 0);
        return result;
    }
}
