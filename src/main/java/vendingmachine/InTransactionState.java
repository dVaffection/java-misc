package vendingmachine;

import java.util.*;

public class InTransactionState implements State {

    private Collection<Coin> credit;
    private VendingMachine   vendingMachine;
    private Storage          storage;
    private Till             till;

    public InTransactionState(Collection<Coin> credit, VendingMachine vendingMachine, Storage storage, Till till) {
        this.credit = credit;
        this.vendingMachine = vendingMachine;
        this.storage = storage;
        this.till = till;
    }

    @Override
    public void fillWithProducts(Collection<Product> products) throws StateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void credit(Collection<Coin> coins) throws StateException {
        credit.addAll(coins);
    }

    @Override
    public void chooseProduct(String name) throws TillException, StateException {
        // we'll change state to idle regardless any valid outcome
        IdleState state = new IdleState(vendingMachine, storage, till);

        try {
            Product product = storage.getProduct(name);
            Collection<Coin> change = till.charge(credit, product.getPrice());

            state.setProduct(product);
            state.setChange(change);

            // once product found and paid remove it from storage
            storage.removeProduct(name);
        } catch (StorageException e) {
            // product was not found in stock, return user his money
            state.setChange(credit);
        }

        vendingMachine.changeState(state);
    }

    @Override
    public Product getProduct() throws StateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Coin> getChange() throws StateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InTransactionState that = (InTransactionState) o;

        if (!credit.equals(that.credit)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return credit.hashCode();
    }
}
