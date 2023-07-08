import adapters.SquarePegAdapter;
import round.RoundHole;
import round.RoundPeg;
import square.SquarePeg;

/**
 * Adapter use example
 */
public class Main {
    public static void main(String[] args) {
        // Round fits, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("Round peg with radius 5 fits round hole with radius 5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg with width 2 fits round hole with radius 5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg with width 20 does not fit into round hole with radius 5.");
        }
    }
}