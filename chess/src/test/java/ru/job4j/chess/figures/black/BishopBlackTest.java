package ru.job4j.chess.figures.black;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static ru.job4j.chess.firuges.Cell.findBy;
//import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void positionMethod() {
        BishopBlack bishop = new BishopBlack(Cell.B1);
        Cell result = bishop.position();
        assertThat(result, is(Cell.B1));
    }

    @Test
    public void copyMethod() {
        BishopBlack bishop = new BishopBlack(Cell.B1);
        Cell result = bishop.copy(Cell.C2).position();
        assertThat(result, is(Cell.C2));
    }

    @Test
    public void wayMethodIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test (expected = IllegalStateException.class)
    public void wayMethodIsNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.C1, Cell.B1);
    }

    @Test
    public void isPossibleToMove() {
        Logic log = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C8);
        log.add(bishop);
        boolean result = log.move(bishop.position(), Cell.E6);
        assertThat(result, is(true));
    }

    @Test (expected = IllegalStateException.class)
    public void isImpossibleToMove() {
        Logic log = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C8);
        BishopBlack bishop2 = new BishopBlack(Cell.D7);
        log.add(bishop);
        log.add(bishop2);
        log.move(bishop.position(), Cell.E6);
    }
}

