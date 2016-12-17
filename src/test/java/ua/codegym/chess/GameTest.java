package ua.codegym.chess;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.Assert.assertThat;

public class GameTest {

  @Test
  public void saveAndRestoreGameState() {
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    Game game = new Game();
    game.turn("e2e4");
    game.save(os);

    byte[] state = os.toByteArray();
    InputStream is = new ByteArrayInputStream(state);

    Game restored = Game.from(is);
    assertThat(game, CoreMatchers.is(restored));
  }
}
