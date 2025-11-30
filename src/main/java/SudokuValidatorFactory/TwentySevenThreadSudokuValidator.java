package SudokuValidatorFactory;

import org.project.*;

import java.util.ArrayList;

public class TwentySevenThreadSudokuValidator implements SudokuValidator {
    private Board board;
    private ResultCollector collector;

    public TwentySevenThreadSudokuValidator(Board board , ResultCollector collector) {
        this.collector = collector;
        this.board = board;
    }

    @Override
    public void validate() {
        ArrayList<Thread> threads = new ArrayList<>();
        int i;

        for(i = 0; i < 9 ; i++)
        {
            threads.add(new Thread(new SingleRowChecker(board,collector,i)));
        }

        for(i = 0; i < 9 ; i++)
        {
            threads.add(new Thread(new SingleColumnChecker(board,collector,i)));
        }

        for(i = 0; i < 9 ; i++)
        {
            threads.add(new Thread(new SingleBoxChecker(board,collector,i)));
        }

        for(Thread t : threads)
        {
            t.start();
        }

        for(Thread t : threads)
        {try
        {
            t.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        }

    }
}
