package org.example.model.product;

public class Product {

    private String[] keyWords;

    public Product() {
        this.keyWords = new String[]{"Product1", "Product2", "Product3"};
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }

}
