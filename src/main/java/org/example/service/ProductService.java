package org.example.service;

import org.example.exception.LevelNotFoundException;
import org.example.exception.KeyWordsNotFoundException;
import org.example.model.product.Product;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProductService {
    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    //Assume we want to get keywords as a list
    public List<String> getProductKeyWords(Product product) {
        if (product.getKeyWords() != null && product.getKeyWords().length > 0 ) {
            return Arrays.stream(product.getKeyWords()).collect(Collectors.toList());
        } else
            throw new KeyWordsNotFoundException("Can't find keywords for product");
    }

    /*
    Because the privateProductLevel method may be called recursively and needs to keep the level variable as a parameter,
    we want to hide the underlying method so that a client call doesn't pass an arbitrary level variable that can cause
    errors
     */
    public int getProductLevel(Product product) {
        try {
            return privateProductLevel(product, 0);
        } catch (InstantiationException e) {
            logger.log(Level.SEVERE, "Error trying to instantiate class: {0}", e.getMessage());
            throw new LevelNotFoundException("Unable to find product level");
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, "Error trying to access class: {0}", e.getMessage());
            throw new LevelNotFoundException("Unable to find product level");
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "Null object: {0}", e.getMessage());
            throw new LevelNotFoundException("Unable to find product level");

        }
    }

    /*
        To get a class level, I assume 0 is the level for root class, 1 is for classes that inherit from Root class,
        and so on
     */
    private int privateProductLevel(Product product, int level) throws InstantiationException, IllegalAccessException {
        //check if it has a father -> checking for null superclass wouldn't work in this case because all classes inherit from Object class
        //check if father also has a father recursively
        //increment level as more fathers are found
        if (product.getClass().getSimpleName().equals("Product")){
            return level;
        }
        else {
            Product parent = (Product) product.getClass().getSuperclass().newInstance();
            level = privateProductLevel(parent, level);
            level++;
        }
        return level;
    }
}
