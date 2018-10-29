package lv.helloit.board;

import lv.helloit.board.pieces.Figure;

public class Field {
    private Figure figure;

    public Field(Figure figure) {
        if (figure == null) {
            throw new NullPointerException("Figure can't be null");
        }

        this.figure = figure;
    }

    public Field() {
    }

    public boolean isEmpty() {
        return figure == null;
    }

    public void clear() {
        this.figure = null;
    }

    public Figure figure() {
        return this.figure;
    }

    @Override
    public String toString() {
        return this.figure == null ? "\u2014" : figure.toString();
    }
}
