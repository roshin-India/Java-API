package org.ecommerce.productservice2024.controllers;

import org.ecommerce.productservice2024.models.Product;
import org.ecommerce.productservice2024.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product") //in handler mapping
public class ProductController {
    ProductServices productServices;
    public ProductController(ProductServices productServices){

        this.productServices=productServices;
    }

    //get single product
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productServices.getSingleProduct(id);
    }
    // get all product
    @GetMapping()
    public List<Product> getAllProduct(){
        return productServices.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id")Long id,@RequestBody Product product){
       return productServices.replaceProduct(id,product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long id,@RequestBody Product product){
       return productServices.updateProduct(id,product);


    }

}

/*ProductController
    create product
    get product
    update product
    delete product
    MySQL DB

    client ---> product service---> database(product:id,name,quantity,price)  (later)

    Fakestore api is used to code product service.(3rd party api interaction)

    client ---> product service---> Fakestore api (product:id,name,quantity,price)
              (proxy service)
    How to call 3rd party api from product service
 */
