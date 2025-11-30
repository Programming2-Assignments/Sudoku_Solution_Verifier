package org.project;

import java.util.List;

public class RowChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;

    public RowChecker(Board board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            for (int r = 0; r < 9; r++) {
                int[] row = new int[9];
                for (int c = 0; c < 9; c++) row[c] = board.get(r, c);
                List<DuplicateRecord> dups = du.checkRow(r, row);
                collector.addAll(dups);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
