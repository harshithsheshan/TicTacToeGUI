package tictactoe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Class to represent the board on which ticTacToe is played.
 */
class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  public BoardPanel(ReadonlyTttModel model) {
    this.model = model;

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Dimension d = this.getSize();
    //draw a centered horizontal line
    g.drawLine(0, d.height / 3, d.width, d.height / 3);
    g.drawLine(0, 2 * (d.height / 3), d.width, 2 * (d.height / 3));
    g.drawLine(d.width / 3, 0, d.width / 3, d.height);
    g.drawLine(2 * (d.width / 3), 0, 2 * (d.width / 3), d.height);
    Player[][] board = model.getBoard();
    g.drawString("Turn\t" + model.getTurn(), d.width / 2 - 30, 10);
    g.setFont(new Font(Font.SERIF, Font.PLAIN, 100));


    // iterate over board, draw X and O accordingly
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int x = j * d.width / 3 + 50;
        int y = i * d.height / 3 + 100;
        if (board[i][j] != null) {
          if (board[i][j].toString().equals("X")) {
            g.drawString("X", x, y);
          }
          if (board[i][j].toString().equals("O")) {
            g.drawString("O", x, y);
          }
        }
      }
    }

  }
}
