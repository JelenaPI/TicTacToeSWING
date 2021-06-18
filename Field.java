package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Field extends JPanel {

    static Cell buttonA3;
    static Cell buttonB3;
    static Cell buttonC3;
    static Cell buttonA2;
    static Cell buttonB2;
    static Cell buttonC2;
    static Cell buttonA1;
    static Cell buttonB1;
    static Cell buttonC1;
    static ArrayList<Cell> freeButtons;

    public Field() {
        freeButtons = new ArrayList<>();
        this.setLayout(new GridLayout(3, 3));
        this.setSize(450,450);
        this.setLocation(0,30);
        setVisible(true);
        buttonA3 = new Cell("A3");
        buttonB3 = new Cell("B3");
        buttonC3 = new Cell("C3");
        buttonA2 = new Cell("A2");
        buttonB2 = new Cell("B2");
        buttonC2 = new Cell("C2");
        buttonA1 = new Cell("A1");
        buttonB1 = new Cell("B1");
        buttonC1 = new Cell("C1");
        freeButtons.addAll(List.of(buttonA3,buttonB3,buttonC3,buttonA2,buttonB2,buttonC2,buttonA1,buttonB1,buttonC1));
        for(Cell b:freeButtons) add(b);
        this.setVisible(true);
    }
    public static void blockCells() {
        for (Cell x : List.of(buttonA3,buttonB3,buttonC3,buttonA2,buttonB2,buttonC2,buttonA1,buttonB1,buttonC1)) {
            x.setEnabled(false);
        }
    }
    public static void unlockCells() {
        for (Cell x : List.of(buttonA3,buttonB3,buttonC3,buttonA2,buttonB2,buttonC2,buttonA1,buttonB1,buttonC1)) {
            x.setEnabled(true);
        }
    }
    public static void resetButtons() {
        for(Cell b:(List.of(buttonA3,buttonB3,buttonC3,
                buttonA2,buttonB2,buttonC2,buttonA1,buttonB1,buttonC1))) {
            b.setText(" ");
        }
        freeButtons.clear();
        freeButtons.addAll(List.of(buttonA3,buttonB3,buttonC3,buttonA2,buttonB2,buttonC2,buttonA1,buttonB1,buttonC1));
    }

    public static String whoWins() {
        String message;
        message = "";
        if (checkIfThreeIsSame(buttonA1, buttonB1, buttonC1)) {
            message = buttonA1.getText();
        }
        if (checkIfThreeIsSame(buttonA2, buttonB2, buttonC2)) {
            message = buttonA2.getText();
        }
        if (checkIfThreeIsSame(buttonA3, buttonB3, buttonC3)) {
            message = buttonA3.getText();
        }
        if (checkIfThreeIsSame(buttonA1, buttonA2, buttonA3)) {
            message = buttonA1.getText();
        }
        if (checkIfThreeIsSame(buttonB1, buttonB2, buttonB3)) {
            message = buttonB1.getText();
        }
        if (checkIfThreeIsSame(buttonC1, buttonC2, buttonC3)) {
            message = buttonC1.getText();
        }
        if (checkIfThreeIsSame(buttonA1, buttonB2, buttonC3)) {
            message = buttonA1.getText();
        }
        if (checkIfThreeIsSame(buttonA3, buttonB2, buttonC1)) {
            message = buttonC1.getText();
        }
        if (! message.equals("")) {
            if (message.equals("X")) {
                message = "The "+TicTacToe.player1.getName()+" Player (X) wins";
            } else {
                message = "The " + TicTacToe.player2.getName() + " Player (O) wins";
            }
        }
        return message;
    }

    public static boolean checkIfThreeIsSame(Cell a, Cell b, Cell c) {
        if(a.getText().equals(" ")) {
            return false;
        }
        return (a.getText().equals(b.getText()) && b.getText().equals(c.getText()));
    }
    public static boolean isFull(){
         return TicTacToe.counter == 9;
    }
}
