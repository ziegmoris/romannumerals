package converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void name() {
        assertEquals("1", Converter.convert("I"));
    }
}