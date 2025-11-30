package org.project;

import java.util.List;

public class ColumnChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;

    public ColumnChecker(Board board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            for (int c = 0; c < 9; c++) {
                int[] column = new int[9];
                for (int r = 0; r < 9; r++) column[r] = board.get(r, c);
                List<DuplicateRecord> dups = du.checkColumn(c, column);
                collector.addAll(dups);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
