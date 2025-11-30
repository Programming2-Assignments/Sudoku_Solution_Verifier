package org.project;

import java.util.List;

public class SingleRowChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;
    private final int rowIndex;

    public SingleRowChecker(Board board, ResultCollector collector, int rowIndex) {
        this.board = board;
        this.collector = collector;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            int[] row = new int[9];
            for (int c = 0; c < 9; c++) row[c] = board.get(rowIndex, c);
            List<DuplicateRecord> dups = du.checkRow(rowIndex, row);
            collector.addAll(dups);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
