package org.project;

import java.util.List;

public class SingleColumnChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;
    private final int colIndex;

    public SingleColumnChecker(Board board, ResultCollector collector, int colIndex) {
        this.board = board;
        this.collector = collector;
        this.colIndex = colIndex;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            int[] col = new int[9];
            for (int r = 0; r < 9; r++) col[r] = board.get(r, colIndex);
            List<DuplicateRecord> dups = du.checkColumn(colIndex, col);
            collector.addAll(dups);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
