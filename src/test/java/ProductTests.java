import org.example.exception.LevelNotFoundException;
import org.example.exception.KeyWordsNotFoundException;
import org.example.model.product.electronics.Electronics;
import org.example.model.product.furniture.Furniture;
import org.example.model.product.homeappliances.HomeAppliance;
import org.example.model.product.homeappliances.lawngarden.LawnGarden;
import org.example.model.product.homeappliances.majorappliances.GeneralAppliances;
import org.example.model.product.Product;
import org.example.model.product.homeappliances.majorappliances.KitchenAppliances;
import org.example.model.product.homeappliances.majorappliances.MajorAppliances;
import org.example.model.product.homeappliances.minorappliances.MinorAppliances;
import org.example.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTests {


    @Test
    void checkProductKeyWords() {
        Product p = new Product();
        Product m = new MajorAppliances();
        Product f = new Furniture();
        Product h = new HomeAppliance();
        //Should have base keywords
        assertArrayEquals(new String[]{"Product1", "Product2", "Product3"}, p.getKeyWords());
        //Should have its own keywords
        assertArrayEquals(new String[]{"Furniture1", "Furniture2", "Furniture3"}, f.getKeyWords());
        //Should have its own keywords
        assertArrayEquals(new String[]{"MajorAppliance1", "MajorAppliance2", "MajorAppliance3"}, m.getKeyWords());
        //Should have has its own keywords
        assertArrayEquals(new String[]{"HomeAppliance1", "HomeAppliance2", "HomeAppliance3"}, h.getKeyWords());

    }
    @Test
    void checkInheritedKeyWords() {
        //should inherit root product keywords
        Product e = new Electronics();
        Product l = new LawnGarden();
        Product m = new MinorAppliances();
        Product c = new KitchenAppliances();
        GeneralAppliances g = new GeneralAppliances();
        //Should inherit root product keywords
        assertArrayEquals(new String[]{"Product1", "Product2", "Product3"}, e.getKeyWords());
        //Should inherit home appliances keywords
        assertArrayEquals(new String[]{"HomeAppliance1", "HomeAppliance2", "HomeAppliance3"}, l.getKeyWords());
        //Should inherit home appliances keywords
        assertArrayEquals(new String[]{"HomeAppliance1", "HomeAppliance2", "HomeAppliance3"}, m.getKeyWords());
        //Should inherit major appliances keywords
        assertArrayEquals(new String[]{"MajorAppliance1", "MajorAppliance2", "MajorAppliance3"}, c.getKeyWords());
        //Should inherit major appliances keywords
        assertArrayEquals(new String[]{"MajorAppliance1", "MajorAppliance2", "MajorAppliance3"}, g.getKeyWords());
    }

    @Test
    void checkProductKeyWordsService() {
        Product p = new Product();
        ProductService productService = new ProductService();
        List<String> expectedProductKeyWords = Arrays.asList("Product1","Product2","Product3");

        assertEquals(expectedProductKeyWords, productService.getProductKeyWords(p));
    }

    @Test
    void checkProductLevel() {
        Product p = new Product();
        Product f = new Furniture();
        Product m = new MajorAppliances();
        Product g = new GeneralAppliances();
        ProductService productService = new ProductService();
        assertEquals(0, productService.getProductLevel(p));
        assertEquals(1, productService.getProductLevel(f));
        assertEquals(2, productService.getProductLevel(m));
        assertEquals(3, productService.getProductLevel(g));
    }

    @Test
    void checkKeyWordsNotFound() {
        Product productWithNullKeyWords = new Product();
        Product productWithEmptyKeyWords = new Product();
        ProductService productService = new ProductService();
        productWithNullKeyWords.setKeyWords(null);
        productWithEmptyKeyWords.setKeyWords(new String[]{});
        assertThrows(KeyWordsNotFoundException.class, () -> productService.getProductKeyWords(productWithNullKeyWords));
        assertThrows(KeyWordsNotFoundException.class, () -> productService.getProductKeyWords(productWithEmptyKeyWords));
    }

    @Test
    void checkLevelNotFound() {
        ProductService productService = new ProductService();
        assertThrows(LevelNotFoundException.class, () -> productService.getProductLevel(null));
    }

}
