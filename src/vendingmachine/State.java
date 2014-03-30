package vendingmachine;

import java.util.*;

interface State {

    public void fill(Collection<Product> products) throws StateException;

    public void credit(Collection<Coin> coins) throws StateException;

    public void chooseProduct(String name) throws StorageException, TillException, StateException;

    public Product getProduct() throws StateException;

    public Collection<Coin> getChange() throws StateException;

}
