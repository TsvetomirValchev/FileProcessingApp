package FileManagers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordSwapperTest {

    @Test
    @DisplayName("should throw an exception when given invalid line indices")
    void swapWordsWithInvalidLineIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(3, 0, 0, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(0, 0, 3, 0));
    }

    @Test
    @DisplayName("should throw an exception when given invalid word indices")
    void swapWordsWithInvalidWordIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(0, 0, 0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(0, 0, 3, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(3, 0, 0, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> WordSwapper.swapWords(0, 3, 0, 0));
    }

}
