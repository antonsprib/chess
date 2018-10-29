package lv.helloit.controller;

import lv.helloit.board.Board;
import lv.helloit.board.Coords;
import lv.helloit.board.Move;
import lv.helloit.board.exceptions.WrongFromFieldException;

import java.util.Scanner;

public class GameController {
    private Board board;

    public void start() throws Exception {
        board = new Board();
        this.startGameLoop();
    }

    private void startGameLoop() throws Exception {
        while (true) {
            this.print();
            Move move = readPlayerMove();
            try {
                board.makeMove(move);
            } catch (WrongFromFieldException e) {
                System.out.println(e.errorMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Move readPlayerMove() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("It's %s turn. Enter your move: \n From: \n", this.board.isWhiteTurn() ? "white" : "black");
        String fromX = sc.nextLine();
        String fromY = sc.nextLine();

        System.out.println("To:");
        String toX = sc.nextLine();
        String toY = sc.nextLine();

        return new Move.Builder()
                .from(new Coords.Builder()
                        .x((byte) (Byte.parseByte(fromX) - 1))
                        .y((byte) (Byte.parseByte(fromY) - 1))
                        .build())
                .to(new Coords.Builder()
                        .x((byte) (Byte.parseByte(toX) - 1))
                        .y((byte) (Byte.parseByte(toY) - 1))
                        .build())
                .build();
    }

    private void print() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.print(board.getBoard()[i][j]);
            }
            System.out.println();
        }
    }
}