package org.project;

import java.util.List;

public class BoxChecker implements Runnable {
    private final Board board;
    private final ResultCollector collector;

    public BoxChecker(Board board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        try {
            DuplicateUtils du = new DuplicateUtils();
            for (int b = 0; b < 9; b++) {
                int startRow = (b / 3) * 3;
                int startCol = (b % 3) * 3;
                int[][] box = new int[3][3];
                for (int dr = 0; dr < 3; dr++) {
                    for (int dc = 0; dc < 3; dc++) {
                        box[dr][dc] = board.get(startRow + dr, startCol + dc);
                    }
                }
                List<DuplicateRecord> dups = du.checkBox(box);
                collector.addAll(dups);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
