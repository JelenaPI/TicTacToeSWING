import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Cell extends JButton implements ActionListener {
    Cell(int mark){

        setBounds((mark % 3)*150, (mark / 3)*150, 150, 150);
        setName("b" + mark);
        setText(" ");
        setVisible(true);
        addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!TicTacToc.endOfGame){
            //statusLabel.setText("Game in progress");

            System.out.println("now playing "+ TicTacToc.player);
            if (this.getText().equals(" ")){
                this.setText(""+TicTacToc.player);
                int mark = Integer.parseInt(""+this.getName().charAt(1));
                System.out.println(mark);
                TicTacToc.field.setElement(mark / 3,mark % 3, TicTacToc.player) ;
                TicTacToc.player = TicTacToc.changePlayer(TicTacToc.player);
                TicTacToc.field.printWithDashes();
                String data = TicTacToc.b0.getText()+TicTacToc.b1.getText()+TicTacToc.b2.getText()+
                        TicTacToc.b3.getText()+TicTacToc.b4.getText()+TicTacToc.b5.getText()+
                        TicTacToc.b6.getText()+TicTacToc.b7.getText()+TicTacToc.b8.getText();
                TicTacToc.whoWins(TicTacToc.field, data);
            } else {
                TicTacToc.statusLabel.setText("This field is occupied");
            }

        }
    }
}

