import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class TicTacToc extends Frame implements WindowListener,ActionListener {
    static Field field;
    static char player;
    static JLabel statusLabel;
    static Cell b0;
    static Cell b1;
    static Cell b2;
    static Cell b3;
    static Cell b4;
    static Cell b5;
    static Cell b6;
    static Cell b7;
    static Cell b8;
    static boolean endOfGame;

    public static void main(String[] args) {
        field = new Field();
        field.setElements("         ");
        player = 'X';
        endOfGame = false;
        new TicTacToc();
    }

    public TicTacToc(){
        super();
        addWindowListener(this);
        JFrame f=new JFrame();

        f.setResizable(false);
        f.setSize(450, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tic Tac Toe");
        f.setVisible(true);
        b0 = new Cell(0);
        f.add(b0);
        b1 = new Cell(1);
        f.add(b1);
        b2 = new Cell(2);
        f.add(b2);
        b3 = new Cell(3);
        f.add(b3);
        b4 = new Cell(4);
        f.add(b4);
        b5 = new Cell(5);
        f.add(b5);
        b6 = new Cell(6);
        f.add(b6);
        b7 = new Cell(7);
        f.add(b7);
        b8 = new Cell(8);
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
        endOfGame = false;
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
        int countX = countOccurrences(data,'X');
        int countO = countOccurrences(data,'O');
        if(Math.abs(countX - countO) > 1){
            message = "Impossible";
        } else {
            if(field.isWinner('X')){
                if(field.isWinner('O')){
                    message = "Impossible";
                } else {
                    message ="X wins";
                    endOfGame = true;
                }
            } else {
                if(field.isWinner('O')){
                    message = "O wins";
                    endOfGame = true;
                } else {
                    if(field.isFull(data)){
                        message = "Draw ";
                    } else {
                        message = "Game in progress";
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