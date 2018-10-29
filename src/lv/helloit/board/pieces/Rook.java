package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public class Rook extends Figure {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(this.isWhite){
            return "\u2656";
        } else {
            return "\u265C";
        }
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        int diffY = move.to.y - move.from.y;
        int diffX = move.to.x - move.from.x;
        if (isWhite && (diffY == 0) || (diffX == 0)) {
            return true;
        } else if (!isWhite && (diffY == 0) || (diffX == 0)) {
            return true;
        } else{
            return false;
        }
    }
}
