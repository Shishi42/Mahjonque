package Controller;

import com.example.mahjong.MainActivityBoardGame;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import Core.Cell;
import Core.BoardGame;

public class ConnectFourController extends GameController {


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
            cell.get().setJoueur("X");
            this.update();
        }

    }

    public Optional<Cell> getLastCell(int col) {
        return Arrays.stream(this.boardGame.getGrid().getCellsCol(col)).
                                    filter(c -> c.getJoueur() == "").
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
