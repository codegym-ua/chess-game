package ua.codegym.chess;

public class Board {

  public int[] state;

  public Board() {
    this.state = new int[64];
  }

  private int index(char col, int row) {
    return (row - 1) * 8 + (col - 'a');
  }

  public Figure getFigureOn(char col, int row) {
    int value = state[index(col, row)];
    return Figure.of(value);
  }

  public Board setFigure(char col, int row, Figure figure) {
    Board board = new Board();
    board.state[index(col, row)] = figure.value;
    return board;
  }

  public enum FigureType {
    PAWN(0), ROOK(1), KNIGHT(2), BISHOP(3), KING(4), QUIN(5);

    private static FigureType[] types = {PAWN, ROOK, KNIGHT, BISHOP, KING, QUIN};
    int index;

    FigureType(int index) {
      this.index = index;
    }

    static FigureType valueOf(int index) {
      return types[index];
    }
  }


  public enum Color {
    BLACK(0), WHITE(1);

    int index;

    Color(int index) {
      this.index = index;
    }

    static Color valueOf(int index) {
      return index == 0 ? BLACK : WHITE;
    }
  }

  public static class Figure {
    private final int value;
    private final static Figure[] figures = new Figure[12];

    static {
      for (int i = 0; i < figures.length; i++) {
        figures[i] = new Figure(i);
      }
    }

    public static Figure of(FigureType type, Color color) {
      int index = color.index * 6 + type.index;
      return figures[index];
    }

    public static Figure of(int value) {
      return figures[value];
    }

    private Figure(int value) {
      this.value = value;
    }

    public FigureType getType() {
      return FigureType.valueOf(value % 6);
    }

    public Color getColor() {
      return Color.valueOf(value / 6);
    }
  }
}
