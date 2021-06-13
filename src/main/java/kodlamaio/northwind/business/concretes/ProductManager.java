package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao){
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(),"Products listed successfully");
    }

    @Override
    public DataResult<List<Product>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new SuccessDataResult<>(this.productDao.findAll(pageable).getContent(),"Products listed successfully");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return new SuccessDataResult<>(this.productDao.findAll(sort));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added successfully.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getById(int productId) {
        return new SuccessDataResult<>(this.productDao.getById(productId));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categoryIds) {
        return new SuccessDataResult<>(this.productDao.getByCategory_CategoryIdIn(categoryIds));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByNameAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
        return this.productDao.getProductWithCategoryDetails();
    }
}
