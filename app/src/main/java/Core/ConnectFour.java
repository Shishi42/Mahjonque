package Core;

import java.util.stream.Collectors;


/**
 * This class represent a model for a connect four game
 * @author Mano Brabant
 * @version 1.0
 */
public class ConnectFour extends BoardGame {

    /**
     * This constructor create a new ConnectFour game
     */
    public ConnectFour() {
        super(6, 7);
    }


    @Override
    public boolean checkForWin(BoardPlayer car) {

        return this.getAllLines().stream()
                .anyMatch(line -> this.repeatingMoreThan(line.stream().map(Cell::getPlayer).map(BoardPlayer::toString).collect(Collectors.joining()), car.toChar(), 3));

    }


}
