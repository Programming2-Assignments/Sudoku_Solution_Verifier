package SudokuValidatorFactory;

import org.project.*;

public class SequentialSudokuValidator implements SudokuValidator {
    private Board board;
    private ResultCollector collector;

    public SequentialSudokuValidator(Board board, ResultCollector collector){
        this.board =board;
        this.collector = collector;
    }

    @Override
    public void validate() {
        new RowChecker(board,collector).run();
        new ColumnChecker(board,collector).run();
        new BoxChecker(board,collector).run();
    }
}
