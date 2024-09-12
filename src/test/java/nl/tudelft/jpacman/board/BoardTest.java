package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board;

    /**
     * Create a 1x1 grid with a BasicSquare.
     */
    @BeforeEach
    void setUp() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        board = new Board(grid);
    }

    @Test
    void boardTestConstruction() {
        // Check whether the board has a width of 1 and height of 1
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);

        // Check whether the square at (0,0) is not null
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();

        // Check whether (0,0) is within the borders of the board
        assertThat(board.withinBorders(0, 0)).isTrue();
    }

    @Test
    void boardTestNull() {
        // Create a board with a null square
        Square[][] gridWithNull = new Square[1][1];
        gridWithNull[0][0] = null;

        // Expect an AssertionError because the board contains a null square
        assertThrows(AssertionError.class, () -> new Board(gridWithNull));
    }
}
