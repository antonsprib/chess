package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public class King extends Figure {
    public King(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(this.isWhite){
            return "\u2654";
        } else{
            return "\u265A";
        }
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        int diffY = move.to.y - move.from.y;
        int diffX = move.to.x - move.from.x;

        if((diffY < -1 || diffY > 2) && (diffX < -1 || diffX > 2)){
            return false;
        }
        if(diffX < -1 || diffX > 2){
            return false;
        }
        return true;
    }

//    @Override
//    public boolean checkTheoreticalCorrectness(Move move) {
//        return false;
//    }
}
