package org.ecommerce.productservice2024.services;

import org.ecommerce.productservice2024.Dtos.FakeStoreProductDto;
import org.ecommerce.productservice2024.models.Category;
import org.ecommerce.productservice2024.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")

public class FakeStoreProductServices implements ProductServices {
    RestTemplate restTemplate;

    public FakeStoreProductServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + productId,
                        FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

        //convert FakeStoreProductDto to my product


    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setCategory(new Category(fakeStoreProductDto.getCategory()
                , fakeStoreProductDto.getDescription()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        return product;
    }
    /* 'https://fakestoreapi.com/products/1'
      //output
            {
                id:1,
                title:'...',
                price:'...',
                category:'...',
                description:'...',
                image:'...'
            }
 */

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
   /* 'https://fakestoreapi.com/products'
    //output
      [
                {
                    id:1,
                    title:'...',
                    price:'...',
                    category:'...',
                    description:'...',
                    image:'...'
                },

                {
                    id:30,
                    title:'...',
                    price:'...',
                    category:'...',
                    description:'...',
                    image:'...'
                }
      ]
    */

    @Override
    public Product updateProduct(Long id, Product product) {
        //PATCH
        FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/" + id,
                product,
                FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        //PUT
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor(
                        FakeStoreProductDto.class,
                        restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }


}

