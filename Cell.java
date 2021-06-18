package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Cell extends JButton {
    Cell(String text) {
        super(text);
        this.setText(" ");
        this.setName("Button" + text);
        this.setEnabled(false);
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setFocusPainted(false);
                if (isCellFree()) {
                    setText(TicTacToe.player.getSign());
                    Field.freeButtons.remove(this);
                    TicTacToe.counter++;
                    TicTacToe.checkGameStatus();
                    TicTacToe.changePlayer();

                    if(TicTacToe.player.getName().equals("Robot")) {
                        TicTacToe.robotTakeMove(TicTacToe.player);
                        TicTacToe.checkGameStatus();
                        TicTacToe.changePlayer();
                    }
                } else {
//                    TicTacToe.SetFieldIsOccupied();
                }
            }
        });
        this.setVisible(true);
    }


    private boolean isCellFree() {
        return this.getText().equals(" ");
    }
}

