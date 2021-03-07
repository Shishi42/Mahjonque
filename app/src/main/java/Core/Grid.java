package Core;

import android.widget.Button;

import androidx.annotation.NonNull;

public class Grid {


    private final int NB_ROW;
    private final int NB_COL;
    private Cell[][] cells;


    public Grid(int nbRow, int nbCol) {

        this.NB_ROW = nbRow;
        this.NB_COL = nbCol;

        this.cells = new Cell[this.NB_ROW][this.NB_COL];

        for(int i = 0; i < this.NB_ROW; i++) {
            for(int j = 0; j < this.NB_COL; j++) {

                this.cells[i][j] = new Cell();

            }
        }

    }

    public int getNbRow() {
        return this.NB_ROW;
    }

    public int getNbCol() {
        return this.NB_COL;
    }

    public Cell getCase(int row, int col) {
        return this.cells[row][col];
    }

    public Cell[][] getCells() {
        return this.cells;
    }


    /**
     * This method is used to get every button of a given row
     * @param row The row to return
     * @return Every button of the given row
     */
    public Cell[] getCellsRow(int row) {

        Cell[] ret = new Cell[NB_COL];
        for (int i = 0; i < NB_COL; i++) {
            ret[i] = this.cells[row][i];
        }
        return ret;

    }

    /**
     * This method is used to get every button of a given column
     * @param col The column to return
     * @return Every button of the given column
     */
    public Cell[] getCellsCol(int col) {

        Cell[] ret = new Cell[NB_ROW];
        for (int i = 0; i < NB_ROW; i++) {
            ret[i] = this.cells[i][col];
        }
        return ret;

    }


    /**
     * This method is used to reset the entire board
     */
    protected void resetBoard() {
        for (int i = 0; i < NB_ROW; i++) {
            for (int j = 0; j < NB_COL; j++) {
                cells[i][j].setJoueur("");
            }
        }

    }


    @NonNull
    @Override
    public String toString() {

        String res = "";

        for(int i = 0; i < this.NB_ROW; i++) {
            for(int j = 0; j < this.NB_COL; j++) {

                res += this.cells[i][j].toString();

            }

            res += "\n";

        }

        return res;
    }
}
