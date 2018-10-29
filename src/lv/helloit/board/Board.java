package lv.helloit.board;

import lv.helloit.board.exceptions.WrongFromFieldException;
import lv.helloit.board.pieces.*;

public class Board {
    private Field[][] board;
    private boolean whiteTurn;

    public Board() {
        this.board = new Field[8][8];
        this.whiteTurn = true;

        this.initBoard();
        this.fillPawns(true);
        this.fillPawns(false);
        this.fillRooks();
        this.fillBishop();
        this.fillKnight();
        this.fillQueen();
        this.fillKing();
    }

    // 0. Coords in bound
    // 1. Empty
    // 2. Own color
    // 3. Check move theoretical correctness
    // 4. Context validation
    // 5. Check check


    public void makeMove(Move move) throws Exception {
        validateMove(move);

        board[move.to.x][move.to.y] = board[move.from.x][move.from.y];
        board[move.from.x][move.from.y] = new Field();

        this.whiteTurn = !this.whiteTurn;
    }

    public void validateMove(Move move) throws Exception {
        if (!coordsInBound(move)) {
            throw new Exception("This coordinats doesn't exist");
        }

        if (!figureExists(move.from)) {
            throw new Exception("No any figure on this field");
        }

        if (!figureColorMatchTurn(move.from)) {
            throw new Exception("Can't move rival figures");
        }

        if (!board[move.from.x][move.from.y].figure().checkTheoreticalCorrectness(move)) {
            throw new Exception("Figure cant move like that");
        }

    }

    private boolean coordsInBound(Move move) {
        if(move.to.x <= 8 && move.to.y <= 8 && move.from.x <=8 && move.from.y <= 8){
            return true;
        } else{
            return false;
        }
    }

    private boolean figureExists(Coords from) {
        if(board[from.x][from.y].isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    private boolean figureColorMatchTurn(Coords from) {
        if(whiteTurn == true && board[from.x][from.y].figure().isWhite()== true){
            return true;
        }else if (whiteTurn == false && board[from.x][from.y].figure().isWhite()== false){
            return true;
        } else{
            return false;
        }
    }


    public Field[][] getBoard() {
        return this.board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    private void initBoard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Field();
            }
        }
    }
    private void fillPawns(boolean isWhite) {
        int rowIndex = isWhite ? 1 : 6;

        for (int i = 0; i < 8; ++i) {
            board[rowIndex][i] = new Field(new Pawn(isWhite));
        }
    }

    private void fillRooks(){
        final int leftColl = 0;
        final int rightColl = 7;

        board[0][leftColl] = new Field(new Rook(true));
        board[0][rightColl] = new Field(new Rook(true));
        board[7][leftColl] = new Field(new Rook(false));
        board[7][rightColl] = new Field(new Rook(false));
    }

    private void fillBishop(){
        final int leftColl = 2;
        final int rightColl = 5;

        board[0][leftColl] = new Field(new Bishop(true));
        board[0][rightColl] = new Field(new Bishop(true));
        board[7][leftColl] = new Field(new Bishop(false));
        board[7][rightColl] = new Field(new Bishop(false));
    }

    private void fillKnight(){
        final int leftColl = 1;
        final int rightColl = 6;

        board[0][leftColl] = new Field(new Knight(true));
        board[0][rightColl] = new Field(new Knight(true));
        board[7][leftColl] = new Field(new Knight(false));
        board[7][rightColl] = new Field(new Knight(false));
    }

    private void fillQueen(){

        board[0][3] = new Field(new Queen(true));
        board[7][3] = new Field(new Queen(false));
    }

    private void fillKing(){

        board[0][4] = new Field(new King(true));
        board[7][4] = new Field(new King(false));
    }
//    private void printKnight(boolean isWhite){
//        int rowIndex = isWhite ? 0 : 7;
//        int leftColl = 1;
//        int rightColl = 6;
//        board[rowIndex][leftColl] = new Knight(isWhite);
//        board[rowIndex][rightColl] = new Knight(isWhite);
//    }
//
//    private void printBishop(boolean isWhite){
//        int rowIndex = isWhite ? 0 : 7;
//        int leftColl = 2;
//        int rightColl = 5;
//        board[rowIndex][leftColl] = new Bishop(isWhite);
//        board[rowIndex][rightColl] = new Bishop(isWhite);
//    }
//
//    private void printQueen(boolean isWhite){
//        int rowIndex = isWhite ? 0 : 7;
//        board[rowIndex][3] = new Queen(isWhite);
//    }
//
//    private void printKing(boolean isWhite){
//        int rowIndex = isWhite ? 0 : 7;
//        board[rowIndex][4] = new King(isWhite);
//    }
}
