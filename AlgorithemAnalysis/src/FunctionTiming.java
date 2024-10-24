import java.util.concurrent.TimeUnit;

public class FunctionTiming {

    public static void main(String[] args) {
        // Define how many times to repeat the loop for each function
        int repeat = 1000;

        // Measure the time for each function
        measureExecutionTime(repeat, "y = 5log(x)", (x) -> 5 * Math.log(x));
        measureExecutionTime(repeat, "y = 7xlog(x)", (x) -> 7 * x * Math.log(x));
        measureExecutionTime(repeat, "y = 2^x", (x) -> Math.pow(2, x));
        measureExecutionTime(repeat, "y = x^2", (x) -> Math.pow(x, 2));
        measureExecutionTime(repeat, "y = 10x^2", (x) -> 10 * Math.pow(x, 2));
    }

    // Generic method to measure execution time for a given function
    public static void measureExecutionTime(int repeat, String functionName, MathFunction function) {
        long totalTime = 0;

        // Execute the loop and measure time for each iteration
        for (int i = 0; i < 5; i++) {  // Run the loop multiple times to get average time
            long startTime = System.nanoTime();

            for (int x = 1; x < repeat; x++) {
                // Perform the work (compute the function)
                function.compute(x);
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            totalTime += duration;

            System.out.println("Execution time for " + functionName + " in iteration " + (i + 1) + ": " + duration + " ns");
        }

        long averageTime = totalTime / 5;
        System.out.println("Average execution time for " + functionName + ": " + averageTime + " ns\n");
    }

    // Functional interface to pass different mathematical functions
    @FunctionalInterface
    interface MathFunction {
        double compute(double x);
    }
}
