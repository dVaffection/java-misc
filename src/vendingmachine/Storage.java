package vendingmachine;

import java.util.ArrayList;
import java.util.Collection;

class Storage {

    ArrayList<Product> products;

    public void addProducts(Collection<Product> products) {
        this.products.addAll(products);
    }


}
