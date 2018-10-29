package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public class Bishop extends Figure {
    public Bishop(boolean isWhite){
        super(isWhite);
    }

    public String toString(){
        if(this.isWhite){
            return "\u2657";
        } else{
            return "\u265D";
        }
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        int diffY = move.to.y - move.from.y;
        int diffX = move.to.x - move.from.x;

        if(diffX == Math.abs(diffY) || diffX == diffY){
            return true;
        } else{
            return false;
        }
    }

//    @Override
//    public boolean checkTheoreticalCorrectness(Move move) {
//        return false;
//    }

}
