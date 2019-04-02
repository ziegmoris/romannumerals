package converter;

import enums.ArabicEnum;
import enums.RomanEnum;
import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConverterTest {

    //Roman Numerals

    @Test
    public void shouldReturn1GivenI() throws ParseException {
        assertEquals("1", Converter.convert("I"));
    }

    @Test
    public void shouldReturn5GivenV() throws ParseException {
        assertEquals("5", Converter.convert("V"));
    }

    @Test
    public void shouldReturn10GivenX() throws ParseException {
        assertEquals("10", Converter.convert("X"));
    }

    @Test
    public void shouldReturn50GivenL() throws ParseException {
        assertEquals("50", Converter.convert("L"));
    }

    @Test
    public void shouldReturn100GivenC() throws ParseException {
        assertEquals("100", Converter.convert("C"));
    }

    @Test
    public void shouldReturn500GivenD() throws ParseException {
        assertEquals("500", Converter.convert("D"));
    }

    @Test
    public void shouldReturn1000GivenM() throws ParseException {
        assertEquals("1000", Converter.convert("M"));
    }

    @Test
    public void shouldReturn2GivenII() throws ParseException {
        assertEquals("2", Converter.convert("II"));
    }

    @Test
    public void shouldReturn3GivenIII() throws ParseException {
        assertEquals("3", Converter.convert("III"));
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenIIII() throws ParseException {
        Converter.convert("IIII");
    }

    @Test
    public void shouldReturn6GivenVI() throws ParseException {
        assertEquals("6", Converter.convert("VI"));
    }

    @Test
    public void shouldReturn4GivenIV() throws ParseException {
        assertEquals("4", Converter.convert("IV"));
    }

    @Test
    public void shouldReturn3000GivenMMM() throws ParseException {
        assertEquals("3000", Converter.convert("MMM"));
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenMMMI() throws ParseException {
        Converter.convert("MMMI");
    }

    @Test
    public void shouldReturn20GivenXX() throws ParseException {
        assertEquals("20", Converter.convert("XX"));
    }

    @Test
    public void shouldReturn10GivenVV() throws ParseException {
        assertEquals("10", Converter.convert("VV"));
    }

    @Test
    public void shouldReturn49GivenXLIX() throws ParseException {
        assertEquals("49", Converter.convert("XLIX"));
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenIL() throws ParseException {
        Converter.convert("IL");
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenA() throws ParseException {
        Converter.convert("A");
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenI1() throws ParseException {
        Converter.convert("I1");
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenVL() throws ParseException {
        Converter.convert("VL");
    }

    //Arabic Numerals

    @Test
    public void shouldReturnIGiven1() throws ParseException {
        assertEquals("I", Converter.convert("1"));
    }

    @Test
    public void shouldReturnVGiven5() throws ParseException {
        assertEquals("V", Converter.convert("5"));
    }

    @Test
    public void shouldReturnXGiven10() throws ParseException {
        assertEquals("X", Converter.convert("10"));
    }

    @Test
    public void shouldReturnLGiven50() throws ParseException {
        assertEquals("L", Converter.convert("50"));
    }

    @Test
    public void shouldReturnCGiven100() throws ParseException {
        assertEquals("C", Converter.convert("100"));
    }

    @Test
    public void shouldReturnDGiven500() throws ParseException {
        assertEquals("D", Converter.convert("500"));
    }

    @Test
    public void shouldReturnMGiven1000() throws ParseException {
        assertEquals("M", Converter.convert("1000"));
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGiven3001() throws ParseException {
        Converter.convert("3001");
    }

    @Test
    public void shouldReturnXXGiven20() throws ParseException {
        assertEquals("XX", Converter.convert("20"));
    }

    @Test
    public void shouldReturnXLIXGiven49() throws ParseException {
        assertEquals("XLIX", Converter.convert("49"));
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGiven0() throws ParseException {
        Converter.convert("0");
    }

    @Test(expected = ParseException.class)
    public void shouldReturnErrorGivenNegative1() throws ParseException {
        Converter.convert("-1");
    }

    @Test
    public void shouldPrintOutEnums() {
        try {
            Arrays.asList(ArabicEnum.values()).forEach(System.out::println);
            Arrays.asList(RomanEnum.values()).forEach(System.out::println);
        } catch (Exception e) {
            fail();
        }
    }
}