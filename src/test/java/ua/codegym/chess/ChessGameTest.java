package ua.codegym.chess;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static ua.codegym.chess.FigureType.PAWN;

public class ChessGameTest {

  @Test
  public void firstTurnWorks() {
    ChessGame game = new ChessGame();
    game.turn("e2e4");
    State state = game.getState();
    Figure figure = state.getFigureOn('e', 4);
    Assert.assertThat(figure.getType(), is(PAWN));
  }
}
