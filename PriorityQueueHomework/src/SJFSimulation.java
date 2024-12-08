import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Process {
    private String name;
    private int executionTime;

    public Process(String name, int executionTime) {
        this.name = name;
        this.executionTime = executionTime;
    }

    public String getName() {
        return name;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "Process{name='" + name + "', executionTime=" + executionTime + '}';
    }
}

public class SJFSimulation {
    public static void main(String[] args) {
        // List of processes
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 5));
        processes.add(new Process("P2", 3));
        processes.add(new Process("P3", 8));
        processes.add(new Process("P4", 2));

        System.out.println("Initial Queue:");
        logProcesses(processes);

        processes.sort(Comparator.comparingInt(Process::getExecutionTime));

        /*
        What this line does:
processes.sort(...):

This is a method from Java's List interface.
It sorts the processes list in-place (modifies the original list) based on the rules defined in the Comparator.
Comparator.comparingInt(...):

This is a utility method from the Comparator class that generates a comparator for integers.
It tells the sort() method how to compare the objects in the list. In this case, it compares the processes based on their execution time.
Process::getExecutionTime:

This is a method reference in Java.
It refers to the getExecutionTime() method in the Process class.
This means the comparator will call getExecutionTime() on each Process object in the list to extract its execution time for comparison.
         */

        System.out.println("Queue after sorting (Shortest Job First):");
        logProcesses(processes);

        // Execute processes one by one
        for (Process process : processes) {
            System.out.println("Executing process: " + process);
            System.out.println("Process completed: " + process.getName());
        }
    }

    private static void logProcesses(List<Process> processes) {
        for (Process process : processes) {
            System.out.println(process);
        }
        System.out.println();
    }
}
