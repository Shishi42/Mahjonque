package Core;

import androidx.annotation.NonNull;


/**
 * This class represent a grid for that can be used for a board game
 * @author Mano Brabant
 * @version 1.0
 */
public class Grid {

    private final int NB_ROW;
    private final int NB_COL;
    private final Cell[][] cells;


    /**
     * This constructor create a new grid
     * @param nbRow The number of row of the new grid
     * @param nbCol The number of column of the new grid
     */
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


    /**
     * This method return the number of row of the grid
     * @return The number of row
     */
    public int getNbRow() {
        return this.NB_ROW;
    }


    /**
     * This method return the number of column of the grid
     * @return The number of column
     */
    public int getNbCol() {
        return this.NB_COL;
    }


    /**
     * This method return a cell of the grid
     * @param row The row of the cell
     * @param col The column of the cell
     * @return The cell at the given row and column
     */
    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }


    /**
     * This method return the cells of the grid
     * @return The cells of the grid
     */
    public Cell[][] getCells() {
        return this.cells;
    }


    /**
     * This method is used to get every cell of a given row
     * @param row The row to return
     * @return Every cell of the given row
     */
    public Cell[] getCellsRow(int row) {

        Cell[] ret = new Cell[NB_COL];
        for (int i = 0; i < NB_COL; i++) {
            ret[i] = this.cells[row][i];
        }
        return ret;

    }

    /**
     * This method is used to get every cell of a given column
     * @param col The column to return
     * @return Every cell of the given column
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
    public void resetBoard() {
        for (int i = 0; i < NB_ROW; i++) {
            for (int j = 0; j < NB_COL; j++) {
                cells[i][j].setPlayer(BoardPlayer.NONE);
            }
        }

    }


    @NonNull
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < this.NB_ROW; i++) {
            for(int j = 0; j < this.NB_COL; j++) {

                res.append(this.cells[i][j].toString());

            }

            res.append("\n");

        }

        return res.toString();
    }

}
