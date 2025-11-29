package org.project;

import java.io.BufferedReader;
import java.io.FileReader;

public class Board {
    private final int[][] grid = new int[9][9];

    public Board(String csvPath) throws Exception {
        loadFromCsv(csvPath);
    }

    private void loadFromCsv(String path) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 9) {
                String[] parts = line.split(",");
                if (parts.length != 9) {
                    throw new IllegalArgumentException("Each line must have 9 numbers");
                }
                for (int col = 0; col < 9; col++) {
                    grid[row][col] = Integer.parseInt(parts[col].trim());
                }
                row++;
            }

            if (row != 9) {
                throw new IllegalArgumentException("File must contain 9 lines");
            }
        }
    }

    public int get(int r, int c) {
        return grid[r][c];
    }
}
