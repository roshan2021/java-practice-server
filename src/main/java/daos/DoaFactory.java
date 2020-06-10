package daos;

import interfaces.Products;

public class DoaFactory {
    private static Products productsDao;

    public static Products getProductsDao() {
        if(productsDao == null) {
            productsDao = new ListProducts();
        }
        return productsDao;
    }
}
