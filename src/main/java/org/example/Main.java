package org.example;

import org.example.model.product.Product;
import org.example.model.product.furniture.Furniture;
import org.example.model.product.homeappliances.majorappliances.GeneralAppliances;
import org.example.service.ProductService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {


        //General demonstration of product categories and their functionalities, including level in the hierarchy
        //and keywords


        Product p = new Product();
        Product f = new Furniture();
        Product g = new GeneralAppliances();

        //product service
        ProductService productService = new ProductService();

        //a General Appliance is a type of Major Appliance, a Major Appliance is a type of Home Appliance,
        //a Home appliance is a type of product
        logger.log(Level.INFO, "Root product level: {0}",productService.getProductLevel(p));
        logger.log(Level.INFO, "Furniture level: {0}",productService.getProductLevel(f));
        logger.log(Level.INFO, "General appliance level: {0}",productService.getProductLevel(g));

        logger.log(Level.INFO, "Root product keywords: {0}", productService.getProductKeyWords(p));
        logger.log(Level.INFO, "Furniture product keywords: {0}", productService.getProductKeyWords(f));
        logger.log(Level.INFO, "General product keywords: {0}", productService.getProductKeyWords(g));

    }
}