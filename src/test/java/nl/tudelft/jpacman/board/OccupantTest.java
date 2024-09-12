package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // hasSquare() return True iff the unit is occupying a square at the moment
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Create square -> Occupy the square with the unit
        Square square = new BasicSquare();
        unit.occupy(square);

        // Check whether the unit occupies square and square is occupied with the unit
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Create squares -> Occupy the squares with the unit
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();

        unit.occupy(square1); // occupy the 1st square

        // Check whether the unit occupies square1 and square1 is occupied with the unit
        assertThat(unit.getSquare()).isEqualTo(square1);
        assertThat(square1.getOccupants()).contains(unit);

        unit.occupy(square2); // Reoccupy the 2nd square

        // Check whether the unit no longer occupies square1
        assertThat(square1.getOccupants()).doesNotContain(unit);

        // Check whether the unit occupies square2 and square2 is occupied with the unit
        assertThat(unit.getSquare()).isEqualTo(square2);
        assertThat(square2.getOccupants()).contains(unit);
    }
}
