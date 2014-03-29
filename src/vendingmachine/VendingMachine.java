package vendingmachine;

import java.util.Collection;

public class VendingMachine {

    Storage storage = new Storage();
    Till    till    = new Till();

    public void fill(Collection<Product> products) {
        storage.addProducts(products);
    }

    public Product buy(String name, Collection<Coin> coins) {
        return null;
    }

}
