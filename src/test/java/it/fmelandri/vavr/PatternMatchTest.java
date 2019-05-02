package it.fmelandri.vavr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static io.vavr.API.*;
import io.vavr.control.Option;

public class PatternMatchTest 
{
    @Test
    public void ShouldCalMatch()
    {
        Integer input = 2;
        String output = Match(input).of(
            Case($(1), "one"),
            Case($(2), "two")
        );
        assertEquals("two", output);
    }

    @Test
    public void ShouldCalMatchOptionSom()
    {
        Integer input = 2;
        Option<String> output = Match(input).option(
            Case($(1), "one"),
            Case($(2), "two"),
            Case($(), s -> Option.none().toString())
        );
        assertEquals("two", output.getOrElse("one"));
    }

    @Test
    public void ShouldCalMatchOptionNone()
    {
        Integer input = 3;
        Option<String> output = Match(input).option(
            Case($(1), "one"),
            Case($(2), "two"),
            Case($(), i -> Option.none().toString())            
        );
        assertEquals("None", output.getOrElse("None"));
    }
}
