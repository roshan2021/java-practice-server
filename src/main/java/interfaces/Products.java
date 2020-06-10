package interfaces;

import models.Product;
import java.util.List;

public interface Products {
    List<Product> all();
    //CRUD FUNCTIONALITY
    void insert(Product product);
    Product findOne(long id);
}