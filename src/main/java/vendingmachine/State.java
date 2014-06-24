package vendingmachine;

import java.util.*;

interface State {

    void fillWithProducts(Collection<Product> products) throws StateException;

    void credit(Collection<Coin> coins) throws StateException;

    void chooseProduct(String name) throws TillException, StateException;

    Product getProduct() throws StateException;

    Collection<Coin> getChange() throws StateException;

}
