package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categoryIds);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId);
}
