package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public abstract class Figure  {
    protected boolean isWhite;

    public Figure(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    @Override
    public abstract String toString();

    public abstract boolean checkTheoreticalCorrectness(Move move);
}
