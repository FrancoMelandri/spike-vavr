package it.fmelandri.vavr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.vavr.control.Either;
import io.vavr.*;

public class EitherTest 
{
    static Either<String, Integer> get(Integer i) {
        if (i < 80) return Either.left("Wrong value");
        return Either.right(i);
    }

    @Test
    public void ShouldCallLeft()
    {
        Either<String, Integer> either = get(50);
        assertTrue( either.isLeft() );
    }

    @Test
    public void ShouldCalRight()
    {
        Either<String, Integer> either = get(90);
        assertTrue( either.isRight() );
    }

    @Test
    public void ShouldGetLeft()
    {
        String either = get(10).fold(s -> s, i -> i.toString());
        assertTrue( either == "Wrong value" );
    }

    @Test
    public void ShouldGetRight()
    {
        String either = get(90).fold(s -> s, i -> i.toString());
        assertEquals( "90", either );
    }

    @Test
    public void ShouldGetRightWithFunctio()
    {
        Function1<Integer, Either<String, Integer>> getEither = (i) -> {
            if (i < 80) return Either.left("Wrong value");
            return Either.right(i);
        };
        String either = getEither.apply(90).fold(s -> s, i -> i.toString());
        assertEquals( "90", either );
    }
}
