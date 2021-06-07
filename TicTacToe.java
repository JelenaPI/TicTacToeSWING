package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class TicTacToe extends JFrame implements WindowListener, ActionListener {
    static JButton buttonReset;
    static Field field;
    static char player;
    static JLabel labelStatus;
    static boolean endOfGame;
    static int counter;

    public TicTacToe(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,530);
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addWindowListener(this);
        field = new Field();
        add(field);
        labelStatus = new JLabel();
        labelStatus.setBounds(25, 450, 150, 40);
        labelStatus.setText("Game is not started");
        labelStatus.setVisible(true);
        add(labelStatus);
        labelStatus.setVisible(true);
        labelStatus.setName("LabelStatus");

        setVisible(true);
        buttonReset = new JButton();
        buttonReset.setName("ButtonReset");
        buttonReset.setBounds(320, 453, 90, 30);
        buttonReset.setText("Reset");
        buttonReset.addActionListener(this);
        buttonReset.setVisible(true);
        buttonReset.enableInputMethods(true);
        add(buttonReset);
        counter = 0;
        player = 'X';
        setVisible(true);
    }

    public static void placePlayerAndCheckForWinner() {
        counter++;
        labelStatus.setText("Game in progress");
        changePlayer();
        checkGameStatus();
    }

    public static void SetFieldIsOccupied() {
        labelStatus.setText("This field is occupied");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        endOfGame = false;
        labelStatus.setText("Game is not started");
        Field.resetButtons();
        player = 'X';
        counter = 0;
    }

    public static void changePlayer(){
        if ('X' == player){
            player = 'O';
            return;
        }
        player = 'X';
    }

    public static void checkGameStatus(){
        String message;
        if(counter > 4) {
            message = Field.DoWeHaveAWinner();
            if (message.equals("")) {
                if (Field.isFull()) {
                    message = "Draw";
                    endOfGame = true;
                } else {
                    message = "Game in progress";
                }
            } else {
                endOfGame = true;
            }
            labelStatus.setText(message);
        }
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