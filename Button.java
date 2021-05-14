/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static tictactoe.TestSwing.statusLabel;

public class Button extends JButton implements ActionListener {
    Button(int mark){
        
        setBounds((mark % 3)*150, (mark / 3)*150, 150, 150);
        setVisible(true);
        setName("b" + mark);
        setText(" ");
        addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        statusLabel.setText("Game in progress");
        while(!TestSwing.endOfGame){
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

