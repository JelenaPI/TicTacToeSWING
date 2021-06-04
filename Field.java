import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private char [][] elements;

    Field() {
        setLayout(new GridLayout(3, 3));
        this.elements = new char[3][3];
        this.elements[0][0] ='X';
        this.elements[0][1] ='X';
        this.elements[0][2]= 'X';

        this.elements[1][0]= 'O';
        this.elements[1][1]= 'O';
        this.elements[1][2]= 'X';

        this.elements[2][0]= 'X';
        this.elements[2][1]= 'O';
        this.elements[2][2]= 'O';

    }
    public char[][] getElements() {
        return this.elements;
    }

    public void print() {
        for (char[] row : this.elements) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }System.out.println();
    }
    public void printWithDashes() {
        System.out.println("---------");

        for (char[] row : this.elements) {
            System.out.print("| ");
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.print("|");
            System.out.println();
        }System.out.println("---------");
    }
    public void setElements(String data){
        for(int k = 0; k < 9; k++){
            this.elements[k/3][k%3] = data.charAt(k);
        }
    }
    public boolean isWinner(char winer){
        boolean someoneWin = false;
        int i = 0;
        someoneWin = checkIfThreeIsSame(winer, elements[0][0], elements[1][1], elements[2][2]);
        if (!someoneWin){
            someoneWin = checkIfThreeIsSame(winer, elements[2][0], elements[1][1], elements[0][2]);

        }
        while(!someoneWin && i < 3 ){
            someoneWin = checkIfThreeIsSame(winer, elements[i][0], elements[i][1], elements[i][2]);
            if (!someoneWin){
                someoneWin = checkIfThreeIsSame(winer, elements[0][i], elements[1][i], elements[2][i]);
            }
            i++;
        }
        return someoneWin;
    }
    public boolean checkIfThreeIsSame(char win,char a,char b, char c){
        if (win == a && a == b && b == c){
            return true;
        }
        return false;
    }
    public boolean isFull(String data){
        return !data.contains(" ");
    }

    public void setElement(int i, int i1, char player) {
        elements[i][i1] = player;
    }
}
