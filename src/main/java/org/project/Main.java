package org.project;

import SudokuValidatorFactory.SudokuValidator;
import SudokuValidatorFactory.SudokuValidatorFactory;

public class Main {

    public static void main(String[] args) {
        try {
            // Validate command-line arguments
            if (args.length != 2) {
                printUsage();
                return;
            }

            String csvPath = args[0];
            int mode = Integer.parseInt(args[1]);

            // Load board and set up validation
            Board board = new Board(csvPath);
            ResultCollector collector = new ResultCollector();
            SudokuValidator validator;
            SudokuValidatorFactory factory = new SudokuValidatorFactory();
            validator = factory.createValidator(mode, board, collector);
            validator.validate();

            // Display results
            if (collector.isValid()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID\n");
                printDuplicates(collector);
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // acceptable for CLI debugging
        }
    }

    private static void printUsage() {
        System.out.println("Incorrect arguments.");
        System.out.println("Usage:");
        System.out.println("  java -jar SudokuValidator.jar <csv-path> <mode>");
        System.out.println("Where:");
        System.out.println("  <csv-path> : path to the 9x9 Sudoku CSV file");
        System.out.println("  <mode>     : validation mode (0, 3, or 27)");
        System.out.println();
        System.out.println("Example:");
        System.out.println("  java -jar SudokuValidator.jar board.csv 3");
    }

    private static void printDuplicates(ResultCollector collector) {
        // Rows
        for (DuplicateRecord d : collector.getDuplicateRows()) {
            System.out.println(d);
        }
        if (!collector.getDuplicateRows().isEmpty()) {
            System.out.println("------------------------------\n");
        }

        // Columns
        for (DuplicateRecord d : collector.getDuplicateCols()) {
            System.out.println(d);
        }
        if (!collector.getDuplicateCols().isEmpty()) {
            System.out.println("------------------------------\n");
        }

        // Boxes
        for (DuplicateRecord d : collector.getDuplicateBoxes()) {
            System.out.println(d);
        }
        if (!collector.getDuplicateBoxes().isEmpty()) {
            System.out.println("------------------------------\n");
        }
    }
}
