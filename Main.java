/*
 * This progam uses the Triangle class to give the user information about the
 * triangle they have inputted.
 *
 * @author  Roman Cernetchi
 * @version 1.0
 * @since   2022-01-07
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** This is a stub program for the Vehicle subclasses. */
final class Main {

    /**
     * Prevents instantiation.
     * Throw an exception IllegalStateException when called.
     *
     * @throws IllegalStateException shouldn't be instantiated
     */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Reusable user input catcher.
    *
    * @param prompt prompt to display to the user
    * @return input as an int
    * @throws IOException if anything unexpected happens
    */
    private static double userInput(final String prompt) throws IOException {
        System.out.print(prompt);

        final String inputString = new BufferedReader(
                new InputStreamReader(System.in)
        ).readLine();

        return Double.parseDouble(inputString);
    }

    /**
     * Gets user input for the 3 sides and displays info about the triangle.
     *
     * @param args No args will be used.
     */
    public static void main(final String[] args) {
        try {
            final Triangle triangle = new Triangle(
                userInput("1st Side (Any unit): "),
                userInput("2nd Side (Same unit): "),
                userInput("3rd Side (Same unit): ")
            );

            System.out.println(
                "\nType: " + triangle.getName()
                + "\n\nThe lengths based on the units and numbers used are..."
                + "\nArea: " + triangle.getArea()
                + "\nPerimeter: " + triangle.getPerimeter()
                + "\nSemiperimeter: " + triangle.getSemiperimeter()
                + "\nAngles (order[1st to last]): "
                + Arrays.toString(triangle.getAngles())
                + "\nHeights (order[1st to last]): "
                + Arrays.toString(triangle.getHeights())
                + "\nIncircle Radius: " + triangle.getIncircleRadius()
                + "\nCircumcircle Area: " + triangle.getCircumcircleArea()
            );

        } catch (IOException | NumberFormatException exception) {
            System.out.println("Please enter a valid input.");
        } catch (ArithmeticException exception) {
            System.out.println("Please enter a valid triangle.");
        } finally {
            System.out.println("\nDone.");
        }
    }
}
