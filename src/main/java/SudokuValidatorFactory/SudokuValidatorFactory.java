package SudokuValidatorFactory;

import org.project.*;

public class SudokuValidatorFactory {
    public static SudokuValidator createValidator(int mode, Board board, ResultCollector collector){
        switch(mode){
            case 0:
                return new SequentialSudokuValidator(board,collector);

            case 3 :
                return new ThreeThreadSudokuValidator(board,collector);

            case 27:
                return new TwentySevenThreadSudokuValidator(board,collector);
            default:
                throw new IllegalArgumentException("Invalid mode :" + mode);
        }
    }

}
