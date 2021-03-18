package Core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This class represent an abstract model for a board game
 * @author Mano Brabant
 * @author Benjamin Riviere
 * @version 1.0
 */
public abstract class BoardGame {

    protected Grid grid;
    protected int player1Points;
    protected int player2Points;

    protected boolean winner;

    /**
     * This constructor initialize the general info for a board game
     * @param nbRow The number of row of the board
     * @param nbCol The number of column of the board
     */
    public BoardGame(int nbRow, int nbCol) {

        this.grid = new Grid(nbRow, nbCol);
        this.player1Points = 0;
        this.player2Points = 0;
        this.winner = false;

    }


    /**
     * This method is used to return every available cases.
     * @return All cases a player can press to play
     */
    public List<Cell> getCasesAvailable() {

        return Arrays.stream(this.grid.getCells()).
                flatMap(Arrays::stream).
                filter(b -> b.getPlayer().equals(BoardPlayer.NONE)).
                collect(Collectors.toList());

    }


    /**
     * This method return the Grid of the board game
     * @return The grid of the game
     */
    public Grid getGrid() {
        return this.grid;
    }


    /**
     * This method return the number of point of the player1
     * @return The number of point
     */
    public int getPlayer1Points() {
        return this.player1Points;
    }


    /**
     * This method return the number of point of the player2
     * @return The number of point
     */
    public int getPlayer2Points() {
        return this.player2Points;
    }


    /**
     * This method reset the game
     */
    public void resetGame() {

        player1Points = 0;
        player2Points = 0;
        this.grid.resetBoard();

    }


    /**
     * This method increments the points of the player1
     */
    public void player1Wins() {
        player1Points++;
    }


    /**
     * This method increments the points of the player2
     */
    public void player2Wins() {
        player2Points++;
    }

    /**
     * This method does nothing
     * Nothing happen in the model when there is a draw
     */
    public void draw() {

    }


    /**
     * This method a boolean to tell if a player have wined
     * @return true if one of the players have wined, false otherwise
     */
    public boolean ended() {
        return this.checkForWin(BoardPlayer.PLAYER_ONE) || this.checkForWin(BoardPlayer.PLAYER_TWO);
    }


    /**
     * This method all lines (column, row, diagonal) of the grid
     * @return The list of the available column numbers
     */
    public List<List<Cell>> getAllLines() {

        List<List<Cell>> ret = new LinkedList<>();

        for(int j = 0; j < this.grid.getNbCol(); j++) {

            List<Cell> temp = new LinkedList<>();

            for(int i = 0; i < this.grid.getNbRow(); i++) {
                temp.add(this.grid.getCell(i, j));
            }

            ret.add(temp);

        }


        for(int i = 0; i < this.grid.getNbRow(); i++) {

            List<Cell> temp = new LinkedList<>();

            for(int j = 0; j < this.grid.getNbCol(); j++) {
                temp.add(this.grid.getCell(i, j));
            }

            ret.add(temp);

        }


        for(int k = -this.grid.getNbRow()+1; k < this.grid.getNbRow(); k++) {
            List<Cell> temp = new LinkedList<>();
            for (int i = 0; i < this.grid.getNbRow(); i++) {

                for (int j = 0; j < this.grid.getNbCol(); j++) {
                    if (i == (j - k)) {
                        temp.add(this.grid.getCell(i, j));
                    }
                }
                ret.add(temp);
            }
        }

        for(int k = -this.grid.getNbRow()+1; k < this.grid.getNbRow(); k++) {
            List<Cell> temp = new LinkedList<>();
            for (int i = 0; i < this.grid.getNbRow(); i++) {

                for (int j = 0; j < this.grid.getNbCol(); j++) {
                    if (this.grid.getNbRow() - i == (j - k)) {
                        temp.add(this.grid.getCell(i, j));
                    }
                }
                ret.add(temp);
            }
        }

        return ret;
    }


    /**
     * This method return the column where we can still play
     * @return The list of the available column numbers
     */
    public List<Integer> getColumnAvailable() {

        List<Integer> ret = new LinkedList<>();

        for(int j = 0; j < this.grid.getNbCol(); j++) {
            if(this.grid.getCell(0, j).getPlayer().equals(BoardPlayer.NONE)) {
                ret.add(j);
            }
        }

        return ret;

    }


    /**
     * This method return a boolean to tell if a string contain a repetition of a letter a given number of time
     * @param str The string to look at
     * @param car The letter to look up for
     * @param rep The minimum number of repetition
     * @return true if the str contain a repetition of the letter car at least rep times, false otherwise
     */
    public boolean repeatingMoreThan(String str, char car, int rep) {

        int n = str.length();
        int maxCount = 0;
        int cur_count = 0;

        System.out.println("c'est dl'a bite");
        System.out.println(str);
        System.out.println("\n");

        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == car) {
                cur_count++;
                if (cur_count > maxCount)
                {
                    maxCount = cur_count;
                }
            } else {
                cur_count = 0;
            }

        }

        return maxCount > rep;

    }


    /**
     * This method return if a given player has wined
     * @param car The BoardPlayer
     * @return true if the player has wined, false otherwise
     */
    public abstract boolean checkForWin(BoardPlayer car);


}
