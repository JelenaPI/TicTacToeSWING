package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static javax.swing.BoxLayout.X_AXIS;

public class TicTacToe extends JFrame implements WindowListener, ActionListener {
    static Field field;
    static JLabel labelStatus;
    static boolean endOfGame;
    static int counter;
    static JToolBar toolBar;
    static JButton buttonReset;
    static Player player1;
    static Player player2;
    public static Player player;
    static boolean moveTaken;
    JButton buttonPlayer1;
    JButton buttonPlayer2;


    public TicTacToe(){
        super();

        JMenuBar menuBar = new JMenuBar();
        JMenuItem gameMenuItem = new JMenuItem();

        gameMenuItem.setName("MenuGame");
        setJMenuBar(menuBar);
        menuBar.add(gameMenuItem);
        menuBar.setVisible(true);
        JMenu menuGame = new JMenu("Game");
        menuGame.setMnemonic(KeyEvent.VK_G);

        JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
        menuHumanHuman.setName("MenuHumanHuman");
        menuHumanHuman.setMnemonic(KeyEvent.VK_H);
        menuHumanHuman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setGame("Human", "Human");
            }
        });

        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");
        menuHumanRobot.setMnemonic(KeyEvent.VK_R);
        menuHumanRobot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setGame("Human", "Robot");
            }
        });

        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");
        menuRobotHuman.setMnemonic(KeyEvent.VK_U);
        menuRobotHuman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setGame("Robot", "Human");
            }
        });

        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");
        menuRobotRobot.setMnemonic(KeyEvent.VK_O);
        menuRobotRobot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setGame("Robot", "Robot");

            }
        });

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.setMnemonic(KeyEvent.VK_X);
        menuItemExit.setName("MenuExit");
        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menuGame.add(menuHumanHuman);
        menuGame.add(menuHumanRobot);
        menuGame.add(menuRobotHuman);
        menuGame.add(menuRobotRobot);
        menuGame.addSeparator();
        menuGame.add(menuItemExit);

        menuBar.add(menuGame);
        setJMenuBar(menuBar);

        buttonPlayer1 = new JButton("Human");
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buttonPlayer1.setText(buttonPlayer1.getText().equals("Robot") ? "Human" : "Robot");
                player1.setName(buttonPlayer1.getText());
            }
        });
        buttonPlayer2 = new JButton("Human");
        buttonPlayer2.setName("ButtonPlayer2");
        buttonPlayer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buttonPlayer2.setText(buttonPlayer2.getText().equals("Robot") ? "Human" : "Robot");
                player2.setName(buttonPlayer2.getText());
            }
        });
        buttonReset = new JButton();
        buttonReset.setName("ButtonStartReset");
        buttonReset.setText("Start");
        buttonReset.addActionListener(this);
        buttonReset.enableInputMethods(true);

        toolBar = new JToolBar();
        toolBar.setLayout(new GridLayout(1, 3));
        toolBar.setPreferredSize(new Dimension(450,30));
        toolBar.add(buttonPlayer1);
        toolBar.add(buttonReset);
        toolBar.add(buttonPlayer2);
        toolBar.setFloatable(false);
        toolBar.setVisible(true);
        add(toolBar, X_AXIS);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(450,580);
        this.setTitle("Tic Tac Toe");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        addWindowListener(this);
        field = new Field();
        this.add(field);
        labelStatus = new JLabel();
        labelStatus.setBounds(25, 480, 250, 40);
        labelStatus.setText("Game is not started");
        labelStatus.setVisible(true);
        labelStatus.setVisible(true);
        labelStatus.setName("LabelStatus");
        this.add(labelStatus);

        this.setVisible(true);
         counter = 0;
        player1 = new Player(buttonPlayer1.getText(),"X");
        player2 = new Player(buttonPlayer2.getText(),"O");
        player = player1;
        //ThreadStatus status = new ThreadStatus();

    }

    private void setGame(String first, String second) {
        buttonPlayer1.setText(first);
        player1.setName(first);
        buttonPlayer2.setText(second);
        player2.setName(second);
        buttonReset.setText("Reset");
        player = player1;
        startGame();

    }

    private void startGame() {
        MessageFormat inProgressStatus = new MessageFormat(
                "The turn of {0} Player ({1})");
        MessageFormat finishedStatus = new MessageFormat(
                "The {0} Player ({1}) wins");
        labelStatus.setText("The turn of "+ player.getName()+ " Player (" + player.getSign()+")");
        //labelStatus.setText(inProgressStatus.format(player.getName(),player.getSign()));
        labelStatus.setVisible(true);
        buttonPlayer1.setEnabled(false);
        buttonPlayer2.setEnabled(false);
        Field.unlockCells();
        if(buttonPlayer1.getText().equals("Robot") && buttonPlayer2.getText().equals("Robot")){
                //AKO JE POCETAK IGRE I IGRAJU 2 ROBOTA KOMPJUTER
            while(!endOfGame) {
                robotTakeMove(player);
                checkGameStatus();
                changePlayer();
            }
        }
       if(buttonPlayer1.getText().equals("Robot")) {
            robotTakeMove(player);
            checkGameStatus();
            changePlayer();
        }
    }

    static void changePlayer() {
        if (player == player1) {
            player = player2;
        } else {
            player = player1;
        }
        if(!endOfGame){
            labelStatus.setText("The turn of "+ player.getName()+ " Player (" + player.getSign()+")");
            try {
                Thread.sleep(3);
            } catch (InterruptedException ie)
            {
                System.out.println("Pauza3 secunde");
            }
        }
    }

    public static void SetFieldIsOccupied() {
        labelStatus.setText("This field is occupied");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonReset.getText().equals("Reset")) {
            labelStatus.setText("Game is not started");
            buttonReset.setText("Start");
            endOfGame = false;
            buttonPlayer1.setEnabled(true);
            buttonPlayer2.setEnabled(true);
            Field.resetButtons();
            player = player1;
            counter = 0;
        } else {
            buttonReset.setText("Reset");
            buttonPlayer1.setEnabled(false);
            buttonPlayer2.setEnabled(false);
            for (Cell x : Field.freeButtons) {
                x.setEnabled(true);
            }
            startGame();
        }
    }


    public static void robotTakeMove(Player player) {
        if(!endOfGame) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            Random random = new Random();
            Cell randomButton = Field.freeButtons.get(random.nextInt(Field.freeButtons.size()));
            randomButton.setText(player.getSign());

            Field.freeButtons.remove(randomButton);
            moveTaken = true;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void checkGameStatus(){

        String message = "Game in progress";
        if(counter > 4) {
            message = Field.whoWins();
            if (message.equals("")) {
                if (Field.isFull()) {
                    message = "Draw";
                    endOfGame = true;
                    Field.blockCells();
                } else {
                    message = "Game in progress";
                }
            } else {
                endOfGame = true;
                Field.blockCells();
            }
        }
        labelStatus.setText(message);
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