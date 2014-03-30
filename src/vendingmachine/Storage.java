package vendingmachine;

import java.util.*;

class Storage {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProducts(Collection<Product> products) {
        this.products.addAll(products);
    }

    public Product getProduct(String name) throws StorageException {
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return product;
            }
        }

        String message = String.format("Product \"%s\" is out of stock", name);
        throw new StorageException(message);
    }

    public void removeProduct(String name) throws StorageException {
        Product product = getProduct(name);
        products.remove(product);
    }

}
