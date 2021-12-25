package tictactoe;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * class to represent the view of the TicTacToe in the form of a grid.
 */
public class TicTacToeSwingView extends JFrame implements TicTacToeView {

  private BoardPanel boardPanel;

  /**
   * constructor to intialize the view with a model.
   *
   * @param model TicTacToeModel
   */
  public TicTacToeSwingView(ReadonlyTttModel model) {

    super("Tic-Tac-Toe");
    this.setSize(500, 500);
    Dimension d = this.getSize();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel);
    setResizable(false);

  }


  @Override
  public void addClickListener(TicTacToeController listener) {
    // create the MouseAdapter
    MouseAdapter clickAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        //super.mouseClicked(e);
        // arithmetic to convert panel coords to grid coords
        //e.getX(), e.getY()
        try {
          Dimension d = TicTacToeSwingView.super.getSize();
          if (e.getX() > 0 && e.getX() <= d.width / 3
              && e.getY() > 0 && e.getY() <= d.height / 3) {
            listener.handleCellClick(0, 0);
          } else if (e.getX() > d.width / 3 && e.getX() <= 2 * d.width / 3
              && e.getY() > 0 && e.getY() <= d.height / 3) {
            listener.handleCellClick(0, 1);
          } else if (e.getX() > 2 * d.width / 3 && e.getX() <= d.width
              && e.getY() > 0 && e.getY() <= d.height / 3) {
            listener.handleCellClick(0, 2);
          } else if (e.getX() > 0 && e.getX() <= d.width / 3
              && e.getY() > d.height / 3 && e.getY() <= 2 * d.height / 3) {
            listener.handleCellClick(1, 0);
          } else if (e.getX() > d.width / 3 && e.getX() <= 2 * d.width / 3
              && e.getY() > d.height / 3 && e.getY() <= 2 * d.height / 3) {
            listener.handleCellClick(1, 1);
          } else if (e.getX() > 2 * d.width / 3 && e.getX() <= d.width
              && e.getY() > d.height / 3 && e.getY() <= 2 * d.height / 3) {
            listener.handleCellClick(1, 2);
          } else if (e.getX() > 0 && e.getX() <= d.width / 3
              && e.getY() > 2 * d.height / 3 && e.getY() <= d.height) {
            listener.handleCellClick(2, 0);
          } else if (e.getX() > d.width / 3 && e.getX() <= 2 * d.width / 3
              && e.getY() > 2 * d.height / 3 && e.getY() <= d.height) {
            listener.handleCellClick(2, 1);
          } else if (e.getX() > 2 * d.width / 3 && e.getX() <= d.width
              && e.getY() > 2 * d.height / 3 && e.getY() <= d.height) {
            listener.handleCellClick(2, 2);
          }
        } catch (IllegalArgumentException iae) {
          JOptionPane.showMessageDialog(null, "Position occupied" );
        } catch (IllegalStateException ise) {
          JOptionPane.showMessageDialog(null, "Game Over" );
        }
      }

    };
    boardPanel.addMouseListener(clickAdapter);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public void notify(Player winner) {
    JOptionPane.showMessageDialog(null, "Game won by " + winner.toString());
  }

  @Override
  public void notifyDraw() {
    JOptionPane.showMessageDialog(null, "Game Draw ");

  }

}
