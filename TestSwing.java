
package tictactoe;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;  

public class TestSwing extends Frame implements WindowListener,ActionListener {
    static Field field;
    static char player;
    static JLabel statusLabel;
    static Button b0;
    static Button b1;
    static Button b2;
    static Button b3;
    static Button b4;
    static Button b5;
    static Button b6;
    static Button b7;
    static Button b8;
    boolean endOfGame = false;
    //private static
    //private static
    public static void main(String[] args) {  
              //String data = "         ";
        field = new Field();
        field.setElements("         ");
        player = 'X';
        new TestSwing();//"Tic tac toe");
        //startGame(field);
        

    }
    public static void startGame(Field field){
        player = 'X';
        boolean endOfGame = false;
        while(!endOfGame){
            
 ///           int[] coordinates = {button.getName().charAt(6)/3, button.getName().charAt(6)%3};
            
            if(field.isWinner(player)){
///                statusLabel.setText(player + " wins");
                endOfGame = true;
            }            
            player = changePlayer(player);
        }
        if(!endOfGame){
         //   statusLabel.setText("Draw");
        }
    }
    
    public TestSwing(){
        super();
        addWindowListener(this);
        JFrame f=new JFrame();  
        
        f.setResizable(false);
        f.setSize(450, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tic Tac Toe");
        f.setVisible(true);
        b0 = new Button(0);
        f.add(b0);
        b1 = new Button(1);
        f.add(b1);
        b2 = new Button(2);
        f.add(b2);
        b3 = new Button(3);
        f.add(b3);
        b4 = new Button(4);
        f.add(b4);
        b5 = new Button(5);
        f.add(b5);
        b6 = new Button(6);
        f.add(b6);
        b7 = new Button(7);
        f.add(b7);
        b8 = new Button(8);
        f.add(b8);

        statusLabel = new JLabel();
        statusLabel.setBounds(20, 460, 150, 40);
        
        statusLabel.setText("Game is not started");
        statusLabel.setVisible(true);
        f.add(statusLabel);

        JButton resetButton = new JButton();
        resetButton.setBounds(300, 460, 90, 40);
        resetButton.setText("Reset");
         
        
        resetButton.addActionListener(this);
        f.add(resetButton);

        f.setSize(460,550);
        f.setLayout(null); 
        f.setVisible(true);//making the frame visible 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("button is clicked");
        field.setElements("         ");
        statusLabel.setText("Game in progress");
        b0.setText(" ");
        b1.setText(" ");
        b2.setText(" ");
        b3.setText(" ");
        b4.setText(" ");
        b5.setText(" ");
        b6.setText(" ");
        b7.setText(" ");
        b8.setText(" ");
        player = 'X';
    }

    public static char changePlayer(char player){
        if ('X' == player){
            return 'O';
        }
        return 'X';
    }
          
    public static String whoWins(Field field, String data){
        
        String message;
        String line = data;
        int countX = countOccurrences(data,'X');
        //line = data;
        int countO = countOccurrences(data,'O');
        if(Math.abs(countX - countO) > 1){
            message = "Impossible";
        } else {
            if(field.isWinner('X')){
                if(field.isWinner('O')){
                    message = "Impossible";
                } else {
                    message ="X wins";
                }
            } else {
                if(field.isWinner('O')){
                    message = "O wins";
                } else {
                    if(field.isFull(data)){
                        message = "Draw ";
                    } else {
                        message = "Game not finished";
                    }
                }
            }
        }
        statusLabel.setText(message);
        return message;
        
        
    }
    public static int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                count++;
            }
        }
        return count;
    }

    
    
    
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

    
  
    }

  