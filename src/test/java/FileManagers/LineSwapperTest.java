package FileManagers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineSwapperTest {

    private List<List<String>> text;

    @BeforeEach
    void setUp() {
        text = new ArrayList<>();
        text.add(List.of("Line 1"));
        text.add(List.of("Line 2"));
        text.add(List.of("Line 3"));
        text.add(List.of("Line 4"));
    }

    @Test
    @DisplayName("should swap lines within the range")
    void swapLinesWithinRange() {
        LineSwapper.swapLines(0, 2);
        assertEquals("Line 3", text.get(0).get(0));
        assertEquals("Line 1", text.get(2).get(0));
    }

    @Test
    @DisplayName("should throw an exception when the first line number is out of range")
    void swapLinesWhenFirstLineNumberIsOutOfRange() {
        assertThrows(IndexOutOfBoundsException.class, () -> LineSwapper.swapLines(5, 2));
    }

    @Test
    @DisplayName("should throw an exception when the second line number is out of range")
    void swapLinesWhenSecondLineNumberIsOutOfRange() {
        assertThrows(IndexOutOfBoundsException.class, () -> LineSwapper.swapLines(0, 5));
    }

    @Test
    @DisplayName("Should throw IndexOutOfException when indexes that are out of bound are provided")
    void swapLinesWithWrongLineIndexesShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> LineSwapper.swapLines(20000, 20000));
    }

    @Test
    @DisplayName("should not change the text when swapping the same line number")
    void swapLinesWithSameLineNumber() {
        LineSwapper.swapLines(1, 1);
        assertEquals("Line 2", text.get(1).get(0));
    }
}


