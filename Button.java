package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
    Button(int mark){
        
        setBounds((mark % 3)*150, (mark / 3)*150, 150, 150);
        setName("b" + mark);
        setText(" ");
        setVisible(true);
        addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!TestSwing.endOfGame){
            //statusLabel.setText("Game in progress");
        
            System.out.println("now playing "+TestSwing.player);
            if (this.getText().equals(" ")){
                this.setText(""+TestSwing.player);
                int mark = Integer.parseInt(""+this.getName().charAt(1));
                System.out.println(mark);
                TestSwing.field.setElement(mark / 3,mark % 3, TestSwing.player) ;
                TestSwing.player = TestSwing.changePlayer(TestSwing.player);
                TestSwing.field.printWithDashes();
                String data = TestSwing.b0.getText()+TestSwing.b1.getText()+TestSwing.b2.getText()+
                    TestSwing.b3.getText()+TestSwing.b4.getText()+TestSwing.b5.getText()+
                    TestSwing.b6.getText()+TestSwing.b7.getText()+TestSwing.b8.getText();
                TestSwing.whoWins(TestSwing.field, data);
            } else {
                TestSwing.statusLabel.setText("This field is occupied");
            }
        }
        }
    }

