package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public class Knight extends Figure {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    public String toString() {
        if (this.isWhite) {
            return "\u2658";
        } else {
            return "\u265E";
        }
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        int diffY = move.to.y - move.from.y;
        int diffX = move.to.x - move.from.x;
        if (((diffY == 1) && (diffX == 2))) {
            return true;
        }
        if (((diffY == 2) && (diffX == 1))) {
            return true;
        }
        if (((diffY == 1) && (diffX == -2))) {
            return true;
        }
        if (((diffY == 2) && (diffX == -1))) {
            return true;
        }
        if (((diffY == -1) && (diffX == 2))) {
            return true;
        }
        if (((diffY == -2) && (diffX == 1))) {
            return true;
        }
        if (((diffY == -1) && (diffX == -2))) {
            return true;
        }
        if (((diffY == -2) && (diffX == -1))) {
            return true;
        }
        return false;
    }
}
