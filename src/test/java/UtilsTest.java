import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void testGetClasses() {
        String url = Utils.getCountry("be");
        assertEquals("Result 1", "http://www.wikidata.org/entity/Q31", Utils.getCountry("be"));
        assertEquals("Result 1", "http://www.wikidata.org/entity/Q31", Utils.getCountry("BE"));
        assertEquals("Result 1", null, Utils.getCountry("bdfdfde"));
        assertEquals("Result 1", null, Utils.getCountry(""));
        assertEquals("Result 1", null, Utils.getCountry(null));
    }

}