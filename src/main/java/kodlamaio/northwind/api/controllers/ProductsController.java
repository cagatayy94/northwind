package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getByProductNameOrCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getByCategory_CategoryIdIn")
    public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("getByNameAndCategory_CategoryId")
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getAll/paginate")
    public DataResult<List<Product>> getAll(@RequestParam int page, @RequestParam int size){
        return this.productService.getAll(page, size);
    }
}

