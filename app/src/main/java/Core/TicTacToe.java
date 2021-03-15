package Core;

import java.util.stream.Collectors;


/**
 * This class represent a model for a tic-tac-toe game
 * @author Mano Brabant
 * @version 1.0
 */
public class TicTacToe extends BoardGame {

    /**
     * This constructor create a new TicTacToe game
     */
    public TicTacToe() {
        super(3, 3);
    }


    @Override
    public boolean checkForWin(BoardPlayer car) {

        return this.getAllLines().stream()
                .anyMatch(line -> this.repeatingMoreThan(line.stream().map(Cell::getPlayer).map(BoardPlayer::toString).collect(Collectors.joining()), car.toChar(), 2));

    }


}
