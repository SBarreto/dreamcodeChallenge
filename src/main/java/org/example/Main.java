package org.example;

import org.example.product.Product;
import org.example.product.furniture.Furniture;
import org.example.product.homeappliances.majorappliances.GeneralAppliances;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {


        //General demonstration of product categories and their functionalities, inluding level in the hierarchy
        //and keywords
        Product p = new Product();
        Furniture f = new Furniture();
        GeneralAppliances g = new GeneralAppliances();


        //a General Appliance is a type of Major Appliance, a Major Appliance is a type of Home Appliance,
        //a Home appliance is a type of product
        System.out.println(p.getLevel(0));
        System.out.println(f.getLevel(0));
        System.out.println(g.getLevel(0));

        p.printKeyWords();
        f.printKeyWords();
        g.printKeyWords();
    }
}