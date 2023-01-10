package org.example.product;

import java.util.Arrays;

public class Product {

    private String[] keyWords;

    public Product() {
        this.keyWords = new String[]{"Test1", "Test2", "Test3"};
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }


    /*
        To get a class sublevel, I assume 0 is the level for root class, 1 is for classes that inherit from Root class,
        and so on
     */
    public int getLevel(int level) throws InstantiationException, IllegalAccessException {
        //check if it has a father
        //check if father also has a father recursively
        //increment level as more fathers are found

        if (getClass().getSimpleName().equals("Product")){
            return level;
        }
        else {
            Product parent = (Product) getClass().getSuperclass().newInstance();
            level = parent.getLevel(level);
            level++;
        }
    return level;
    }


    /*
    Show keywords in a nice way, just for demonstration purposes
     */
    public void printKeyWords() {
        System.out.println(Arrays.toString(getKeyWords()));
    }

}
