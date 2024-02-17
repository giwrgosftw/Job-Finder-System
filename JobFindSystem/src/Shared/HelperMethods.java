package Shared;

import java.util.concurrent.ThreadLocalRandom;

public class HelperMethods {
    /**
     * Generates a random integer ID within a specified range.
     *
     * @return A randomly generated integer ID between the specified minimum and maximum values.
     */
    public static int generateRandomIdInt() {
        int min = 10;  // Define the minimum value for the ID range
        int max = 100; // Define the maximum value for the ID range

        // Generate a random integer between min (inclusive) and max (inclusive)
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static Long generateRandomIdLong() {
        int min = 10;  // Define the minimum value for the ID range
        int max = 1000; // Define the maximum value for the ID range

        // Generate a random integer between min (inclusive) and max (inclusive)
        return ThreadLocalRandom.current().nextLong(min, max + 1L);
    }
}
