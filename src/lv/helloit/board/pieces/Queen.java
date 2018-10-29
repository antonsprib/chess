package lv.helloit.board.pieces;

import lv.helloit.board.Move;

public class Queen extends Figure {
    public Queen(boolean isWhite){
        super(isWhite);
    }

    public String toString(){
        if(this.isWhite){
            return "\u2655";
        } else{
            return "\u265B";
        }
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        return false;
    }
}
