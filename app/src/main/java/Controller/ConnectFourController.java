package Controller;

import com.example.mahjong.MainActivityBoardGame;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import Core.Cell;
import Core.BoardGame;

/**
 * This class represent a controller for Connect four game
 * @author Mano Brabant
 * @version 1.0
 */
public class ConnectFourController extends GameController {


    /**
     * This constructor create a new controller for the game Connect four
     * @param boardGame The model of Connect four
     * @param view The view of Connect four
     */
    public ConnectFourController(BoardGame boardGame, MainActivityBoardGame view) {
        super(boardGame, view);
    }


    @Override
    public void clickGrid(int row, int col) {

        if(this.boardGame.ended()) {
            return;
        }

        Optional<Cell> cell = getLastCell(col);

        if(cell.isPresent()) {
            cell.get().setLetter("X");
            this.update();
        }

    }


    /**
     * This method return the last empty cell of a column
     * @param col The column where to look
     * @return The last empty cell of the given column
     */
    public Optional<Cell> getLastCell(int col) {
        return Arrays.stream(this.boardGame.getGrid().getCellsCol(col)).
                                    filter(c -> c.getLetter().equals("")).
                                    reduce((first, second) -> second);
    }


    @Override
    public Cell getPlay() throws NoSuchElementException {

        Optional<Cell> cell = this.getLastCell(this.boardGame.getColumnAvailable().get(new Random().nextInt(this.boardGame.getColumnAvailable().size())));
        if(cell.isPresent()) {
            return cell.get();
        } else {
            throw new NoSuchElementException("public Cell getPlay() throws NoSuchElementException");
        }
    }

}
