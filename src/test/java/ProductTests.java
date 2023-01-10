import org.example.product.furniture.Furniture;
import org.example.product.homeappliances.majorappliances.GeneralAppliances;
import org.example.product.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductTests {


    @Test
    void checkProductKeyWords() {
        Product p = new Product();
        GeneralAppliances g = new GeneralAppliances();
        Furniture f = new Furniture();
        //Assert furniture has its own keywords
        assertArrayEquals(new String[]{"Furniture1", "Furniture2", "Furniture3"}, f.getKeyWords());
        //Assert product has base keywords
        assertArrayEquals(new String[]{"Test1", "Test2", "Test3"}, p.getKeyWords());
        //Assert general appliance inherits product keywords since it doesn't has its own
        assertArrayEquals(new String[]{"Test1", "Test2", "Test3"}, g.getKeyWords());
    }

    @Test
    void checkProductLevel() throws InstantiationException, IllegalAccessException {
        Product p = new Product();
        GeneralAppliances g = new GeneralAppliances();
        Furniture f = new Furniture();
        assertEquals(0, p.getLevel(0));
        assertEquals(1, f.getLevel(0));
        assertEquals(3, g.getLevel(0));
    }
}
