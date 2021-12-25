package tictactoe;


/**
 * Main controller class which is used to control the ticTacToeModel and ticTacToeView.
 */
public class ControllerMain implements TicTacToeController {

  ReadonlyTttModel model;
  TicTacToeView view;

  /**
   * Constructor for the controller which takes view and model.
   *
   * @param model TicTacToe model
   * @param view  View which is the GUI
   */
  public ControllerMain(ReadonlyTttModel model, TicTacToeView view) {
    this.model = model;
    this.view = view;
    view.addClickListener(this);
    view.makeVisible();
  }


  /**
   * Execute a single game of TicTacToe given a TicTacToe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null TicTacToe Model
   */
  @Override
  public void playGame(TicTacToe m) {

    this.model = m;
    view.refresh();

  }

  /**
   * Handle an action in a single cell of the board, such as to make a move.
   *
   * @param row the row of the clicked cell
   * @param col the column of the clicked cell
   */
  @Override
  public void handleCellClick(int row, int col) {
    //System.out.println(row+" "+col);
    ((TicTacToeModel) model).move(row, col);
    view.refresh();
    if (model.isGameOver()) {
      //System.out.println(model.getWinner().toString());
      if (model.getWinner() != null) {
        view.notify(model.getWinner());
      } else {
        view.notifyDraw();
      }
    }
  }

}
