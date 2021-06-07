package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Cell extends JButton implements ActionListener {
    Cell(String text){
        super(text);
        this.setText(" ");
        this.setName("Button" + text);
        addActionListener(this);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setFocusPainted(false);
        if(!TicTacToe.endOfGame) {
        if(IscellFree()){
            setText(""+ TicTacToe.player);
            TicTacToe.placePlayerAndCheckForWinner();
        } else {
            TicTacToe.SetFieldIsOccupied();
        }
        }
    }

    private boolean IscellFree() {
        return this.getText().equals(" ");
    }
}

