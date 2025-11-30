package org.project;

import java.util.List;

public class SingleBoxChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;
    private final int boxIndex;

    public SingleBoxChecker(Board board, ResultCollector collector, int boxIndex) {
        this.board = board;
        this.collector = collector;
        this.boxIndex = boxIndex;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            int startRow = (boxIndex / 3) * 3;
            int startCol = (boxIndex % 3) * 3;
            int[][] box = new int[3][3];
            for (int dr = 0; dr < 3; dr++) {
                for (int dc = 0; dc < 3; dc++) {
                    box[dr][dc] = board.get(startRow + dr, startCol + dc);
                }
            }
            List<DuplicateRecord> dups = du.checkBox(box);
            collector.addAll(dups);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
