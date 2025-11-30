package SudokuValidatorFactory;

import org.project.*;

public class ThreeThreadSudokuValidator implements SudokuValidator {
    private Board board;
    private ResultCollector collector;

    public ThreeThreadSudokuValidator(Board board,ResultCollector collecter) {
        this.board = board;
        this.collector = collecter;
    }

    @Override
    public void validate() {
        Thread t1 = new Thread(new RowChecker(board,collector));
        Thread t2 = new Thread(new ColumnChecker(board,collector));
        Thread t3 = new Thread(new BoxChecker(board,collector));

        t1.start();
        t2.start();
        t3.start();

        try
        {
         t1.join();
         t2.join();
         t3.join();
        }
        catch (InterruptedException e)
        {e.printStackTrace();}
    }
}
