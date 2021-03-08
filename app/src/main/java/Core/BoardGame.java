package Core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BoardGame {

    protected Grid grid;
    protected int player1Points;
    protected int player2Points;

    protected boolean winner;


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
                filter(b -> b.getJoueur() == "").
                collect(Collectors.toList());

    }

    public Grid getGrid() {
        return this.grid;
    }

    public int getPlayer1Points() {
        return this.player1Points;
    }

    public int getPlayer2Points() {
        return this.player2Points;
    }


    /**
     * This method is used to reset the game
     */
    public void resetGame() {

        player1Points = 0;
        player2Points = 0;
        this.grid.resetBoard();

    }


    public void player1Wins() {
        player1Points++;
    }

    public void player2Wins() {
        player2Points++;
    }

    public void draw() {
        this.grid.resetBoard();
    }

    public boolean ended() {
        return this.checkForWin('X') || this.checkForWin('O');
    }

    public List<Integer> getColumnAvailable() {

        List<Integer> ret = new LinkedList<Integer>();

        for(int j = 0; j < this.grid.getNbCol(); j++) {
            if(this.grid.getCase(0, j).getJoueur() == "") {
                ret.add(j);
            }
        }

        return ret;

    }



    public boolean repeatingMoreThan(String str, char car, int rep) {

        int n = str.length();
        int maxCount = 0;
        int cur_count = 0;

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


    public abstract boolean checkForWin(char car);


}
