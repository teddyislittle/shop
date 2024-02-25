package kg.mega.shop.services.impl;

import kg.mega.shop.models.Product;
import kg.mega.shop.services.CategoryService;
import kg.mega.shop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();
    private CategoryService categoryService = CategoryService.INSTANCE;



    public ProductServiceImpl() {
        products.add(new Product(1, "Веселый молочник", 70, 50, categoryService.findCategoryById(1), "123456"));
        products.add(new Product(2, "Мыло", 30, 20, categoryService.findCategoryById(2), "456789"));

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product findProductByBarcode(String barcode) {

        for (Product item:products) {
            if (item.getBarcode().equals(barcode.trim())){
                return item;
            }
        }
        return null;
    }
}
