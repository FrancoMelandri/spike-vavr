package it.fmelandri.vavr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import io.vavr.control.Option;

public class OptionTest 
{
    @Test
    public void ShouldNotmapItemIfNone()
    {
        Option<String> optional = Option.of(null);
        optional.map(value -> { assertTrue(false); return value; });
        assertTrue( true );
    }

    @Test
    public void ShouldmapItemIfSome()
    {
        Option<String> optional = Option.of("some");
        optional.map(value -> { assertEquals("some", value); return value; });
        assertTrue( true );
    }

    @Test
    public void ShouldGetElseIfNone()
    {
        Option<String> optional = Option.of(null);        
        assertEquals("else", optional.getOrElse("else"));
    }

    @Test
    public void ShouldNotGetElseIfSome()
    {
        Option<String> optional = Option.of("some");        
        assertEquals("some", optional.getOrElse("else"));
    }
}
